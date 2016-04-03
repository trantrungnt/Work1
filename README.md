# Work1
##Yêu cầu làm
+ Tạo 1 EditText và 1 nút Button trong MainActivity
+ Khi nhấn nút Button thì hiển thị trong DispalayActivity
+ Nếu EditText chưa có giá trị thì hiển thị hộp Diaglog thông báo cho người dùng

##Chú ý khi code
+ Dùng bundle và intent đẻ gửi thông điệp từ MainActivity đến DisplayActivity
```
    //phuong thuc nhap du lieu tu EditText
    private void typeInput(View v)
    {
        int id = v.getId();
        if(id == R.id.btnSend)
        {
            String inputData;
            inputData = ((EditText) findViewById(R.id.editInput)).getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("KeyData", inputData);

            Intent intentData = new Intent(this, DisplayActivity.class);
            intentData.putExtras(bundle);

            startActivity(intentData);
        }
    }
```

+ Trong  DisplayActivity ta lại dùng bundle và intent để lấy dữ liệu nhận được từ MainActivity
```
 Intent intentDisplay = getIntent();
        Bundle b = intentDisplay.getExtras();
        String strTemp = b.getString("KeyData");
        TextView txtDisplay = (TextView) this.findViewById(R.id.txtDisplay);
        txtDisplay.setText(strTemp);
```

+ Kiểm tra dữ liệu nếu trống hoặc null thì dùng Alert Dialog thông báo cho người dùng phải nhập dữ liệu
```
 int id = v.getId();
        if(id == R.id.btnSend)
        {
            String inputData;
            inputData = ((EditText) findViewById(R.id.editInput)).getText().toString();
            if (inputData.isEmpty() || inputData == null)
            {
                Context context = this;
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                // set title
                alertDialogBuilder.setTitle("WARNING ...");

                // set dialog message
                alertDialogBuilder
                        .setMessage("You need to type your data!")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
            else {
                Bundle bundle = new Bundle();
                bundle.putString("KeyData", inputData);

                Intent intentData = new Intent(MainActivity.this, DisplayActivity.class);
                intentData.putExtras(bundle);

                startActivity(intentData);
            }
        }
```

##Thông tin app Android 
+ App Android dùng api22 
+ Dùng máy ảo Genymotion với hệ điều hành Android version 5.1

##Tham khảo
+ [Android Alert Dialog example](http://www.mkyong.com/android/android-alert-dialog-example/)
+ [Style any activity as an Alert Dialog in Android](http://www.codeproject.com/Tips/623446/Style-Any-Activity-as-an-Alert-Dialog-in-Android)
+ [Android Custom Dialog box sample code](http://www.mysamplecode.com/2011/06/android-custom-dialog-box-sample-code.html)
+ [Android alert dialog](http://www.tutorialspoint.com/android/android_alert_dialoges.htm)
