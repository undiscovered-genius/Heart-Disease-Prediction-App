from flask import Flask, request, jsonify
import pickle
import numpy as np

model = pickle.load(open('model1.pkl','rb'))

app = Flask(__name__)

@app.route('/')
def home():
    return "Heart Disease Prediction App"

@app.route('/predict',methods=['POST'])

#'cp','thalach','slope','restecg','chol','trestbps','fbs','oldpeak'
#[0,108,1,0,250,160,1,1.5] 0
#[3,150,0,0,233,145,1,2.3] 1

def predict():
    cp = request.form.get('cp')
    thalach = request.form.get('thalach')
    slope = request.form.get('slope')
    restecg = request.form.get('restecg')
    chol = request.form.get('chol')
    trestbps = request.form.get('trestbps')
    fbs = request.form.get('fbs')
    oldpeak = request.form.get('oldpeak')

    #result = {'cp':cp,'thalach':thalach,'slope':slope,'restecg':restecg,'chol':chol,'trestbps':trestbps,'fbs':fbs,'oldpeak':oldpeak}

    input_query = np.array([[cp,thalach,slope,restecg,chol,trestbps,fbs,oldpeak]])

    result = model.predict(input_query)[0]

    return jsonify({'hearth_disease': str(result)})

    

if __name__=='__main__':
    app.run(debug=True)