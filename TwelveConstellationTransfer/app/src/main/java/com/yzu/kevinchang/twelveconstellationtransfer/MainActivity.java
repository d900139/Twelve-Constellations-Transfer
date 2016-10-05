package com.yzu.kevinchang.twelveconstellationtransfer;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout ll;
    private TextView tvTitle;
    private EditText edMon;
    private EditText edDay;
    private Button btnGo;
    private TextView tvShow;
    private TextView tvIMG;
    private TextView tvLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = (LinearLayout) findViewById(R.id.mainlayout);
        ll.setBackgroundColor(Color.GRAY);

        // Auto creat TextView tvTitle
        tvTitle = new TextView(this);
        tvTitle.setText("十二星座日期轉換機");
        tvTitle.setTextSize(30);
        tvTitle.setGravity(View.TEXT_ALIGNMENT_GRAVITY); //Make TextView tvTitle center.
        ll.addView(tvTitle);

        // Auto creat EditText edMon
        edMon = new EditText(this);
        edMon.setInputType(InputType.TYPE_CLASS_NUMBER); // Set input type numerical
        edMon.setY(20);
        ll.addView(edMon);

        // Auto creat EditText edDay
        edDay = new EditText(this);
        edDay.setInputType(InputType.TYPE_CLASS_NUMBER); // Set input type numerical
        edDay.setY(25);
        ll.addView(edDay);

        // Auto creat Button btnGo
        btnGo = new Button(this);
        btnGo.setY(70);
        btnGo.setText(R.string.btntitle);
        ll.addView(btnGo);

        // Auto creat TextView tvShow
        tvShow = new TextView(this);
        tvShow.setText("請輸入生日(月/日) !");
        tvShow.setTextSize(30);
        tvShow.setY(110);
        ll.addView(tvShow);

        // Auto creat TextView tvIMG
        tvIMG = new TextView(this);
        tvIMG.setBackgroundResource(R.drawable.twelveconstellation);
        tvIMG.setY(150);
        ll.addView(tvIMG);

        // Auto creat TextView tvLink
        tvLink = new TextView(this);
        tvLink.setText("https://github.com/d900139/Twelve-Constellations-Transfer");
        tvLink.setTextSize(20);
        tvLink.setAutoLinkMask(Linkify.WEB_URLS); // Auto determine the link as web url, also provide email address and phone num.
        tvLink.setMovementMethod(LinkMovementMethod.getInstance()); // Make the link clickable.
        tvLink.setY(220);
        ll.addView(tvLink);
        //Reference: http://rx1226.pixnet.net/blog/post/235665028-%5Bandroid%5D-2-6-%E5%9F%BA%E6%9C%AC%E7%9A%84textview%E4%BB%8B%E7%B4%B9%E5%92%8C%E4%BD%BF%E7%94%A8

        // Set OnClickListener for btnGo
        btnGo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strConstellation = ""; // strConstellation : show Constellation to TextView

                // Get value from EditText edMon and edDay instead of default text "Month" and "Date"
                String strMon = edMon.getText().toString();
                String strDay = edDay.getText().toString();

                // If edMon's value or edDay's value equals "", change it to "0", or it may cause NumberFormatException.
                if (strMon.equals(""))
                    strMon = "0";
                if (strDay.equals(""))
                    strDay = "0";

                // Parse strMon and strDay to Integer
                int mon = Integer.parseInt(strMon);
                int day = Integer.parseInt(strDay);

                if (mon < 1 || mon > 12)
                    strConstellation = "請輸入正確日期 !";

                switch (mon) {
                    case 1:
                        if (day >= 1 && day <= 20)
                            strConstellation = "摩羯座 Capricorn (the Goat)";
                        else if (day >= 21 && day <= 31)
                            strConstellation = "水瓶座 Aquarius (the Water Carrier)";
                        else strConstellation = "請輸入正確日期 !";
                        break;
                    case 2:
                        if (day >= 1 && day <= 19)
                            strConstellation = "水瓶座 Aquarius (the Water Carrier)";
                        else if (day >= 20 && day <= 29)
                            strConstellation = "雙魚座 Pisces (the Fishes)";
                        else strConstellation = "請輸入正確日期 !";
                        break;
                    case 3:
                        if (day >= 1 && day <= 20)
                            strConstellation = "雙魚座 Pisces (the Fishes)";
                        else if (day >= 21 && day <= 31)
                            strConstellation = "牡羊座 Aries (the Ram)";
                        else strConstellation = "請輸入正確日期 !";
                        break;
                    case 4:
                        if (day >= 1 && day <= 20)
                            strConstellation = "牡羊座 Aries (the Ram)";
                        else if (day >= 21 && day <= 30)
                            strConstellation = "金牛座 Taurus (the Bull)";
                        else strConstellation = "請輸入正確日期 !";
                        break;
                    case 5:
                        if (day >= 1 && day <= 21)
                            strConstellation = "金牛座 Taurus (the Bull)";
                        else if (day >= 22 && day <= 31)
                            strConstellation = "雙子座 Gemini (the Twins)";
                        else strConstellation = "請輸入正確日期 !";
                        break;
                    case 6:
                        if (day >= 1 && day <= 21)
                            strConstellation = "雙子座 Gemini (the Twins)";
                        else if (day >= 22 && day <= 30)
                            strConstellation = "巨蠍座 Cancer (the Crab)";
                        else strConstellation = "請輸入正確日期 !";
                        break;
                    case 7:
                        if (day >= 1 && day <= 23)
                            strConstellation = "巨蠍座 Cancer (the Crab)";
                        else if (day >= 24 && day <= 31)
                            strConstellation = "獅子座 Leo (the Lion)";
                        else strConstellation = "請輸入正確日期 !";
                        break;
                    case 8:
                        if (day >= 1 && day <= 23)
                            strConstellation = "獅子座 Leo (the Lion)";
                        else if (day >= 24 && day <= 31)
                            strConstellation = "處女座 Virgo (the Virgin)";
                        else strConstellation = "請輸入正確日期 !";
                        break;
                    case 9:
                        if (day >= 1 && day <= 23)
                            strConstellation = "處女座 Virgo (the Virgin)";
                        else if (day >= 24 && day <= 30)
                            strConstellation = "天秤座 Libra (the Scales)";
                        else strConstellation = "請輸入正確日期 !";
                        break;
                    case 10:
                        if (day >= 1 && day <= 23)
                            strConstellation = "天秤座 Libra (the Scales)";
                        else if (day >= 24 && day <= 31)
                            strConstellation = "天蠍座 Scorpio (the Scorpion)";
                        else strConstellation = "請輸入正確日期 !";
                        break;
                    case 11:
                        if (day >= 1 && day <= 22)
                            strConstellation = "天蠍座 Scorpio (the Scorpion)";
                        else if (day >= 23 && day <= 30)
                            strConstellation = "射手座 Sagittarius (the Archer)";
                        else strConstellation = "請輸入正確日期 !";
                        break;
                    case 12:
                        if (day >= 1 && day <= 22)
                            strConstellation = "射手座 Sagittarius (the Archer)";
                        else if (day >= 23 && day <= 31)
                            strConstellation = "摩羯座 Capricorn (the Goat)";
                        else strConstellation = "請輸入正確日期 !";
                        break;
                }

                tvShow.setText(strConstellation); // Show constellation to TextView tvConstellation
            }
        });
    }
}
