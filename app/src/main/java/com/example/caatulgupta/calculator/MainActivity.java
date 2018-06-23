package com.example.caatulgupta.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tv;
    String ans = "",temp = "";
    int flag = 0;
    boolean add = false, sub = false, mul = false, div = false, res = false;
    boolean addc = false, subc = false, mulc = false, divc = false, decc = false;
    double first = 0.0,second = 0.0;
    boolean f = false, s = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.result);

        add = false;
        sub = false;
        mul = false;
        div = false;

        Button b1 = findViewById(R.id.one);
        b1.setOnClickListener(MainActivity.this);

        Button b2 = findViewById(R.id.two);
        b2.setOnClickListener(this);

        Button b3 = findViewById(R.id.three);
        b3.setOnClickListener(this);

        Button b4 = findViewById(R.id.four);
        b4.setOnClickListener(this);

        Button b5 = findViewById(R.id.five);
        b5.setOnClickListener(this);

        Button b6 = findViewById(R.id.six);
        b6.setOnClickListener(this);

        Button b7 = findViewById(R.id.seven);
        b7.setOnClickListener(this);

        Button b8 = findViewById(R.id.eight);
        b8.setOnClickListener(this);

        Button b9 = findViewById(R.id.nine);
        b9.setOnClickListener(this);

        Button b0 = findViewById(R.id.zero);
        b0.setOnClickListener(this);

        Button bp = findViewById(R.id.add);
        bp.setOnClickListener(this);

        Button bs = findViewById(R.id.sub);
        bs.setOnClickListener(this);

        Button bm = findViewById(R.id.mul);
        bm.setOnClickListener(this);

        Button bd = findViewById(R.id.div);
        bd.setOnClickListener(this);

        Button bclear = findViewById(R.id.clear);
        bclear.setOnClickListener(this);

        Button bequal = findViewById(R.id.equal);
        bequal.setOnClickListener(this);

        Button bdecimal = findViewById(R.id.decimal);
        bdecimal.setOnClickListener(this);

        Button bdel = findViewById(R.id.back);
        bdel.setOnClickListener(this);
    }


    @Override

    public void onClick(View view) {
        int id = view.getId();
        //Button b = findViewById(id);
        //b.setOnClickListener(MainActivity.this);
//        if(add || sub || mul || div){
//
//        }
        switch (id){
            case R.id.one: if(res){ ans = ""; tv.setText(""); res = false; }
                            ans += '1'; temp += '1';
                            tv.setText(ans);
                            break;
            case R.id.two: if(res){ ans = ""; tv.setText(""); res = false; }
                            ans += '2'; temp += '2';
                            tv.setText(ans);
                            break;
            case R.id.three: if(res){ ans = ""; tv.setText(""); res = false; }
                            ans += '3'; temp += '3';
                            tv.setText(ans);
                            break;
            case R.id.four: if(res){ ans = ""; tv.setText(""); res = false; }
                            ans += '4'; temp += '4';
                            tv.setText(ans);
                            break;
            case R.id.five: if(res){ ans = ""; tv.setText(""); res = false; }
                            ans += '5'; temp += '5';
                            tv.setText(ans);
                            break;
            case R.id.six: if(res){ ans = ""; tv.setText(""); res = false; }
                            ans += '6'; temp += '6';
                            tv.setText(ans);
                            break;
            case R.id.seven: if(res){ ans = ""; tv.setText(""); res = false; }
                            ans += '7'; temp += '7';
                            tv.setText(ans);
                            break;
            case R.id.eight: if(res){ ans = ""; tv.setText(""); res = false; }
                            ans += '8'; temp += '8';
                            tv.setText(ans);
                            break;
            case R.id.nine: if(res){ ans = ""; tv.setText(""); res = false; }
                            ans += '9'; temp += '9';
                            tv.setText(ans);
                            break;
            case R.id.zero: if(res){ ans = ""; tv.setText(""); res = false; }
                            ans += '0'; temp += '0';
                            tv.setText(ans);
                            break;
            case R.id.back: if(addc){addc = false;}
                            if(subc){subc = false;}
                            if(mulc){mulc = false;}
                            if(divc){divc = false;}
                            if(decc){decc = false;}
                            if(ans.length()==0){
                                Log.i("Ans","enter 1 if");
                                break;
                            }
                            ans = ans.substring(0,ans.length()-1);
                            Log.i("Ans1","Line 2"+ans);
                            if(temp.length()==0 && ans.length()!=0){
                                ans = ans.substring(0,ans.length()-1);
                                Log.i("Ans2","enter 2 if");
                                break;
                            }
                            temp = temp.substring(0,temp.length()-1);
                            Log.i("Ans3","Line 4"+temp);
                            tv.setText(ans);
                            break;
            case R.id.clear: ans = "";
                            tv.setText("");
                            decc = false;
                            addc = false;
                            subc = false;
                            mulc = false;
                            divc = false;
                            first = 0.0;
                            second = 0.0;
                            f = false;
                            s = false;
                            Log.i("Equal1","First - " + first + " Second- "+ second);
                            flag = 0;
                            break;
            case R.id.decimal: if(decc){break;}
                                decc = true;
                                ans += '.';
                                temp += '.';
                                //findNum(temp);
                            tv.setText(ans);
                            break;
            case R.id.add: //if (addc||mulc||divc){break;}
                            addc = true;
                            ans += '+';
                            res = false;
                            Log.i("Add","F- "+f+" S- "+s);
                if(f && s){
                    first = compute();
                    second = 0.0;
                    ans = toString().valueOf(first);
                    temp = "";
                    //f = false;
                    res = false;
                    s = false;
                }
                            findNum(temp);
                            add = true;
                            temp = "";
                            tv.setText(ans);
                            flag = 1;
                            Log.i("Add","F: "+first+" S: "+second);
                            break;
            case R.id.sub: //if(subc){break;}
                            subc = true;
                            if(addc || mulc || divc){
                                    addc = false; mulc =false; divc = false;
                                    if(ans.length()==0){break;}
                                    ans = ans.substring(0,ans.length()-1);
                            }
                            res = false;
                            ans += '-'; //temp += '-';
                            //sub = true;
                            findNum(temp);
                            sub = true;
                            temp = "";
                            tv.setText(ans);
                            flag = 1;
                            Log.i("Sub","F: "+first+"S: "+second);
                            break;
            case R.id.mul: if(addc||mulc||divc){break;}
                            mulc = true;
                            ans += '*';
                            res = false;
                            findNum(temp);
                            mul = true;
                            temp = "";
                            tv.setText(ans);
                            flag = 1;
                            break;
            case R.id.div: if(addc||mulc||divc){break;}
                            divc = true;
                            ans += '/';
                            res = false;
                            findNum(temp);
                            div = true;
                            temp = "";
                            tv.setText(ans);
                            flag = 1;
                            break;
            case R.id.equal:if(flag==1){
                                findNum(temp);
                                temp = "";
                                decc = false;
                                double dis = compute();
                                first = 0.0;
                                second = 0.0;
                                f = false; s = false;
                                res = true;
                                add = false; sub = false; mul = false; div = false;
                                ans = toString().valueOf(dis);
                                //ans = "";
                                findNum(ans);
                                //Log.i("Equal","First - " + first + " Second - "+ second);
                                tv.setText(ans);
                                flag = 0;
                            }
                            break;
        }
    }
    public void findNum(String temp){
        double d = 0.0;
        decc = false;
        if(temp.length()!=0) {
            d = Double.parseDouble(temp);
            if (add || sub || mul || div) {
                second = d;
                s = true;
            } else {
                first = d;
                f = true;
            }
        }
    }
    public double compute() {

        //first = 0.0;second = 0.0;
        double dis = 0.0;
        decc = false;
        addc = false;
        subc = false;
        mulc = false;
        divc = false;
        //char op = '.';

//        for(int i=0;i<ans.length()-1;i++){
//            if(((int)(ans.charAt(i))<48 || (int)(ans.charAt(i))>57) && (int)(ans.charAt(i))!=46){
//                first = Double.parseDouble(ans.substring(0,i));
//                second = Double.parseDouble(ans.substring(i+1));
//                //op = ans.charAt(i);
//                break;
//            }
//        }
        if(add){
            dis = first+second;
            add = false;
        }else if(sub){
            Log.i("Sub","Minus Working");
            Log.i("Sub","First - " + first + " Second - "+ second);
            dis = first-second;
            sub = false;
        }else if(mul){
            dis = first*second;
            mul = false;
        }else if(div){
            dis = first/second;
            div = false;
        }
        first = 0.0;
        second = 0.0;
        f = false;
        s = false;
//        switch(op){
//            case '+': dis = first+second; break;
//            case '-': dis = first-second; break;
//            case '*': dis = first*second; break;
//            case '/': dis = first/second; break;
//            default: dis = 29.0;
//        }
        return dis;
    }
}
