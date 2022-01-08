package com.example.heartdiseasepredictor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class InfoActivity extends AppCompatActivity {

    List<String> title;
    List<String> info;
    RecyclerView preview;
    HomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        title = new ArrayList<>();
        info = new ArrayList<>();
        preview = findViewById(R.id.preView);

        title.add("Control your blood pressure");
        title.add("Keep your cholesterol and triglyceride levels under control");
        title.add("Manage diabetes");
        title.add("Stay at a healthy weight");
        title.add("Eat a healthy diet");
        title.add("Get regular exercise");
        title.add("Limit alcohol");
        title.add("Don't smoke");
        title.add("Manage stress");
        title.add("Make sure that you get enough sleep");

        info.add("High BP is a major risk factor for heart disease. It is important to get your blood pressure checked regularly - at least once a year for most adults, and more often if you have high blood pressure. Take steps, including lifestyle changes, to prevent or control high blood pressure.");
        info.add("High levels of cholesterol can clog your arteries and raise your risk of coronary artery disease and heart attack. Lifestyle changes and medicines (if needed) can lower your cholesterol. Triglycerides are another type of fat in the blood. High levels of triglycerides may also raise the risk of coronary artery disease, especially in women.\n"+"Total cholesterol level over 200\n" +
                "> HDL (\"good\") cholesterol level under 40\n" +
                "> LDL (\"bad\") cholesterol level over 160\n" +
                "> Triglycerides over 150");
        info.add("Having diabetes doubles your risk of diabetic heart disease. That is because over time, high blood sugar from diabetes can damage your blood vessels and the nerves that control your heart and blood vessels. So, it is important to get tested for diabetes, and if you have it, to keep it under control.");
        info.add("Being overweight or having obesity can increase your risk for heart disease. This is mostly because they are linked to other heart disease risk factors, including high blood cholesterol and triglyceride levels, high blood pressure, and diabetes. Controlling your weight can lower these risks.");
        info.add("Try to limit saturated fats, foods high in sodium, and added sugars. Eat plenty of fresh fruit, vegetables, and whole grains. The DASH diet is an example of an eating plan that can help you to lower your blood pressure and cholesterol, two things that can lower your risk of heart disease.");
        info.add("Exercise has many benefits, including strengthening your heart and improving your circulation. It can also help you maintain a healthy weight and lower cholesterol and blood pressure. All of these can lower your risk of heart disease.");
        info.add("Drinking too much alcohol can raise your blood pressure. It also adds extra calories, which may cause weight gain. Both of those raise your risk of heart disease. Men should have no more than two alcoholic drinks per day, and women should not have more than one.");
        info.add("Cigarette smoking raises your blood pressure and puts you at higher risk for heart attack and stroke. If you do not smoke, do not start. If you do smoke, quitting will lower your risk for heart disease. You can talk with your health care provider for help in finding the best way for you to quit.");
        info.add("Stress is linked to heart disease in many ways. It can raise your blood pressure. Extreme stress can be a \"trigger\" for a heart attack. Also, some common ways of coping with stress, such as overeating, heavy drinking, and smoking, are bad for your heart. Some ways to help manage your stress include exercise, listening to music, focusing on something calm or peaceful, and meditating");
        info.add("If you don't get enough sleep, you raise your risk of high blood pressure, obesity, and diabetes. Those three things can raise your risk for heart disease. Most adults need 7 to 9 hours of sleep per night. Make sure that you have good sleep habits. If you have frequent sleep problems, contact your health care provider. One problem, sleep apnea, causes people to briefly stop breathing many times during sleep. This interferes with your ability to get a good rest and can raise your risk of heart disease. If you think you might have it, ask your doctor about having a sleep study. And if you do have sleep apnea, make sure that you get treatment for it.");

        adapter = new HomeAdapter(this,title,info);

        GridLayoutManager layoutManager = new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false);
        preview.setLayoutManager(layoutManager);
        preview.setAdapter((RecyclerView.Adapter) adapter);
    }
}