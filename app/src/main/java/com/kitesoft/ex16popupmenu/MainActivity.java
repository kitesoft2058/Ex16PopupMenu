package com.kitesoft.ex16popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn= findViewById(R.id.btn);
        btn2= findViewById(R.id.btn2);

        //버튼이 롱클릭되는 것을 듣는 리스너 생성 및 설정
        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                //PopupMenu 객체 생성
                PopupMenu popup= new PopupMenu(MainActivity.this, view); //두 번째 파라미터가 팝업메뉴가 붙을 뷰
                //PopupMenu popup= new PopupMenu(MainActivity.this, btn2); //첫번째 버튼을 눌렀지만 팝업메뉴는 btn2에 붙어서 나타남
                getMenuInflater().inflate(R.menu.popup, popup.getMenu());

                //팝업메뉴의 메뉴아이템을 선택하는 것을 듣는 리스너 객체 생성 및 설정
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()){
                            case R.id.menu_info:
                                Toast.makeText(MainActivity.this, "INFORMATION", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.menu_delete:
                                Toast.makeText(MainActivity.this, "DELETE", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.menu_modify:
                                Toast.makeText(MainActivity.this, "MODIFY", Toast.LENGTH_SHORT).show();
                                break;
                        }

                        return false;
                    }
                });

                popup.show();


                return true;
            }
        });


    }

    public void clickBtn(View v){
        Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
    }

    public void clickBtn2(View view) {
    }
}
