package com.example.register;

import android.os.Bundle;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends Activity {
    private Button btnResigiter,btnCity;
    private EditText editPsd1,editPsd2,name,city;
    private RadioButton  male,famale;
	@Override
	protected void onCreate(Bundle savedInstanceState) {




		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnResigiter=(Button)findViewById(R.id.btnResigter);
		btnCity=(Button)findViewById(R.id.btnCity);
		
		btnResigiter.setOnClickListener(new OnClickListener() {


			
			@Override
			public void onClick(View v) {


				// TODO Auto-generated method stub
				String checkResult=checkInfo();
				if(checkResult!=null){
					Builder  builder=new AlertDialog.Builder(MainActivity.this);
					builder.setTitle("������ʾ");
					builder.setMessage(checkResult);
					builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {


						
						@Override
						public void onClick(DialogInterface dialog, int which) {

							// TODO Auto-generated method stub
							editPsd1.setText("");
							editPsd2.setText("");
						}
					});
					builder.create().show();
				}else{
					Intent intent=new Intent(MainActivity.this,ResultActivity.class);
					intent.putExtra("name",name.getText().toString());
					intent.putExtra("editPsd1",editPsd1.getText().toString());
					String gender=male.isChecked()?"��":"Ů";
					intent.putExtra("gender", gender);
					intent.putExtra("city",city.getText().toString() );
					startActivity(intent);
					
					
				}
				
			}
		});
  btnCity.setOnClickListener(new OnClickListener() {

			
			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,ChooseCityActivity.class);
				//����ָ��Activity���ȴ����صĽ��������0�������룬���ڱ�־������
				startActivityForResult(intent,0);
			}
		});
	}
	
		public void onActivityResult(int requestCode , int resultCode, Intent intent){       


			//��requestCode��resultCodeͬʱΪ0��Ҳ���Ǵ����ض��Ľ��
			if (requestCode == 0&& resultCode == 0){
				
				Bundle data = intent.getExtras();             //ȡ��Intent���Extras����
				
				String resultCity = data.getString("city");          //ȡ��Bundle�е�����
				
				city.setText(resultCity);                      //�޸�city�ı��������
			}
		}
			
		
		public String checkInfo() {



			System.out.println(name);
			if (name.getText().toString() == null||name.getText().toString().equals("")) {
				System.out.println("***********");
				return "�û�������Ϊ��";
			}
			if (editPsd1.getText().toString().trim().length() < 6
					|| editPsd1.getText().toString().trim().length() > 15){
				return "����λ��Ӧ��6~15֮��";
			}
			if(!editPsd1.getText().toString().equals(editPsd2.getText().toString())){
				return "������������벻һ��";
			}
				return null;
		}
		
		
	
		
		
		
	}
		
		
	