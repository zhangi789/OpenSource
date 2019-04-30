package com.dnxc.cn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dnxc.cn.util.BaseUtil;
import com.dnxc.cn.util.GlideUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.tv_nomal)
    TextView tvNomal;
    @BindView(R.id.iv_nomal)
    ImageView ivNomal;
    @BindView(R.id.tv_cricle)
    TextView tvCricle;
    @BindView(R.id.iv_cricle)
    ImageView ivCricle;
    @BindView(R.id.tv_round)
    TextView tvRound;
    @BindView(R.id.iv_round)
    ImageView ivRound;
    private String mUrls = "http://pic9.nipic.com/20100824/2531170_082435310724_2.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
      /*  mA.add(new Student("nage", 12));
        mA.add(new Student("age", 17));
        iv_test1 = (ImageView) findViewById(R.id.iv_test1);
        iv_test2 = (ImageView) findViewById(R.id.iv_test2);
        iv_test3 = (ImageView) findViewById(R.id.iv_test3);
        String jsonStr = JsonUtil.toJson(mA);

        Log.i("GGG", jsonStr);
        GlideUtil.displayImage(this,iv_test1,mUrls);



        GlideUtil.displayImageRoundedRectangleCrop(this,iv_test3,mUrls,R.mipmap.ic_launcher,30);
        List<Student> mAs = mGson.fromJson(jsonStr, new TypeToken<List<Student>>() {
        }.getType());
        //  List<Student> mAs=     JsonUtil.jsontoListBean(jsonStr,Student.class);
        Log.i("GGG", "size  " + mAs.size());
        for (int i = 0; i < mAs.size(); i++) {
            Student student = mAs.get(i);

            Log.i("GGG", student.getKey() + " " + student.getValue());
        }
        String substring = jsonStr.substring(1, jsonStr.length() - 1);

        Log.i("GGG", "kfkdk " + substring);
        List<Student> mAss = JsonUtil.jsontoListBean(substring, Student.class);

        for (int i = 0; i < mAs.size(); i++) {
            Student student = mAs.get(i);

            Log.i("GGG", student.getKey() + " " + student.getValue());
        }
        tv_cricle=(TextView) findViewById(R.id.tv_cricle);
        tv_cricle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"haha",Toast.LENGTH_SHORT).show();
            //    GlideUtil.displayImageCircleCrop(MainActivity.this,iv_test2,mUrls,0);
            }
        });
        iv_cricle2=(TextView) findViewById(R.id.iv_cricle2);



        tv_cricle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

    }

    @OnClick({R.id.tv_nomal, R.id.tv_cricle, R.id.tv_round})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_nomal:
                GlideUtil.displayImage(this,ivNomal,mUrls,R.mipmap.loading);
                break;
            case R.id.tv_cricle:
                GlideUtil.displayImageCircleCrop(this,ivCricle,mUrls,0);
                break;
            case R.id.tv_round:
             //   GlideUtil.displayImageRoundedRectangleCrop(this,ivRound,mUrls,0,30);
                GlideUtil.displayImageRoundedRectangleCrop(this,ivRound,mUrls,R.mipmap.error,30);
                break;
        }
    }
}
