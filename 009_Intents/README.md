<h1>1. Starting other Android components via intents</h1>

<strong>1.1. What is intents?</strong>
- Intent là bản tin không đồng bộ, cho phép các thành phần ứng dụng yêu cầu chức năng từ các thành phần android khác.
- Intent cho phép tương tác giữa các thành phần trong 1 ứng dụng và với các thành phần của ứng dụng khác.
- Một intent có thể chứa dữ liệu thông qua một Bundle, dữ liệu này sẽ được các thành phần nhận sử dụng.

<strong>1.2. Starting activities or services</strong>
- Để khởi chạy một Activity ta sử dụng phương thức startActivity(intent), phương thức này được định nghĩa trong đối tượng Context mà Activity kế thừa.
![alt text](http://www.vogella.com/tutorials/AndroidIntent/img/xstartactivityviaintent10.png.pagespeed.ic.XIxbBb_YEg.webp)
<pre>
<strong>Intent i = new Intent(this, ActivityTwo.class); </strong>
<strong>startActivity(i);</strong>
</pre>
- Để khởi chạy một service ta sử dụng hàm <strong>startService(Intent)</strong>

<strong>1.3. Sending out explicit or implicit intents</strong>
- Android hỗ trợ Intent tường minh và không tường minh.
- Intent tường minh là một ứng dụng sẽ xác định thành phần đích muốn truyền intent tới. Intent tường minh sử dụng trong phạm vi một ứng dụng.
Tạo một intent tường minh sau đó gửi nó cho hệ thống để khởi chạy một Activity:
<pre>
<strong>Intent i = new Intent(this, ActivityTwo.class);</strong>
<strong>i.putExtra("Value1", "This value one for ActivityTwo ");</strong>
<strong>i.putExtra("Value2", "This value two ActivityTwo");</strong>
</pre>

- Intent không tường minh là ứng dụng sẽ hỏi hế thống đánh giá xem những thành phần nào đã đăng ký dựa trên dữ liệu của intent.
- Intent không tường minh chỉ rõ hành động cần thực hiện và dữ liệu tùy chọn cung cấp nội dung cho hành động.
- Nếu một intent được gửi cho hệ thống, nó sẽ tìm toàn bộ các thành phần đã đăng ký hành động cụ thể và kiểu dữ liệu thích hợp. Nếu chỉ một thành phần được tìm thấy nó sẽ khởi chạy luôn, nếu có nhiều thành phần được tìm thấy thì người dùng sẽ lựa chọn trên một dialog
Tạo một intent không tường minh yêu cầu hệ thống tìm và mở một web browser
<pre>
<strong>Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vogella.com"));</strong>
<strong>startActivity(i);</strong>
</pre>

<strong>1.4. Determine valid intent receivers</strong>
- Đôi lúc chúng ta muốn xác định xem một thành phần đã được đăng ký intent chưa.
VD: Chúng ta muốn kiểm tra xem một intent receiver đã có chưa, nếu có rồi thì chúng ta cho phép chức năng trong ứng dụng của mình.
<pre>
<strong>
public static boolean isIntentAvailable(Context ctx, Intent intent) {
    final PackageManager mgr = ctx.getPackageManager();
    List<ResolveInfo> list =
        mgr.queryIntentActivities(intent,
            PackageManager.MATCH_DEFAULT_ONLY);
    return list.size() > 0;
}
</strong>
</pre>

<strong>1.5. Intents as event triggers</strong>
- Intent có thể được sử dụng để quảng bá các bản tin tới hệ thống android.
- Một broadcast receiver có thể đăng ký cho một event và được thông báo nếu event đó được gửi đi.
- Ứng dụng của chúng ta có thể đăng ký các sự kiện của hệ thống.

<h1>2. Data transfer between activities</h1>

<strong>2.1. Data transfer to the target component</strong>
- Một intent chứa header data mô tả action, type, ...
- Một intent còn chứa additional data dựa trên một thể hiện của lớp Bundle, dữ liệu có thể lấy được thông qua phương thức <strong>getExtra()</strong>
- Chúng ta có thể thêm data trực tiếp vào Bundle thông qua phương thức <strong>putExtra()</strong> của đối tượng Intent.
- Extra là một cặp key/value
- Key luôn luôn là String, value là các giá trị có kiểu dữ liệu nguyên thủy và các đối tượng của kiểu String, Bundle, Parcelable, Serializable.
- Các thành phần nhận dữ liệu có thể lấy thông tin thông qua <strong>getAction()</strong> và <strong>getData()</strong> của đối tượng Intent, đối tượng intent có thể lấy được thông qua <strong>getIntent()</strong>
- Thành phần nhận các intent có thể sử dụng <strong>getIntent().getExtra()</strong> để nhận extra data.
VD:
<pre>
<strong>
Bundle extras = getIntent().getExtras();
if (extras == null) {
    return;
}
// get data via the key
String value1 = extras.getString(Intent.EXTRA_TEXT);
if (value1 != null) {
    // do something with the data
}
</strong>
</pre>

<strong>2.2. Example: Using the share intent</strong>
<pre>
<strong>
// this runs, for example, after a button click
Intent intent = new Intent(Intent.ACTION_SEND);
intent.setType("text/plain");
intent.putExtra(android.content.Intent.EXTRA_TEXT, "News for you!");
startActivity(intent);
</strong>
</pre>

<strong>2.3. Retrieving result data from a sub-activity</strong>
- Sử dụng nút back để đóng một activity (hàm finish() được thực hiện)
- Nếu activity được khởi chạy bằng startActivity(intent) thì hàm gọi không yêu cầu kết quả hoặc phản hổi từ activity được đóng.
- Nếu activity được khởi chạy bằng startActivityForResult() thì lúc đó sẽ có phản hồi từ sub-activity, khi sub-activity kết thúc onActivityResult() được gọi và chúng ta có thể thực hiện hành động thông qua kết quả.
- Với startActivityForResult() chúng ta có thể xác định một mã trả về để định rõ chúng ta đã khởi chạy activity nào.
- Activity được khởi chạy còn có thể đưa ra một mã kết quả mà lời gọi có thể sử dụng để xác định activity có bị hủy hay không.
![alt text](http://www.vogella.com/tutorials/AndroidIntent/img/xstartactivity10.png.pagespeed.ic.b9FnPNaKYf.webp)
![alt text](http://www.vogella.com/tutorials/AndroidIntent/img/xstartactivity20.png.pagespeed.ic.MPqk7wd-s2.webp)
- Sub-activity sử dụng finish() để tạo một intent mới và truyền dữ liệu vào nó, Nó còn thiết lập một kết quả thông qua setResult()
VD: Cách thức kích hoạt một intent với hàm startActivityForResult()
<pre>
<strong>
public void onClick(View view) {
    Intent i = new Intent(this, ActivityTwo.class);
    i.putExtra("Value1", "This value one for ActivityTwo ");
    i.putExtra("Value2", "This value two ActivityTwo");
    // set the request code to any code you like,
    // you can identify the callback via this code
    startActivityForResult(i, REQUEST_CODE);
}
</strong>
</pre>

- Nếu sử dụng startActivityForResult() thì sau đó activity được khởi chạy là một sub-activity
- Nếu sub-activity kết thúc, nó có thể gửi data trở lại cho hàm gọi nó thông qua intent, điều này được thực hiện trong hàm finish()
<pre>
<strong>
@Override
public void finish() {
    // Prepare data intent
    Intent data = new Intent();
    data.putExtra("returnKey1", "Swinging on a star. ");
    data.putExtra("returnKey2", "You could be better then you are. ");
    // Activity finished ok, return the data
    setResult(RESULT_OK, data);
    super.finish();
}
</strong>
</pre>
- Một khi sub-activity kết thúc, onActivityResult() trong activity gọi được gọi
<pre>
<strong>
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
        if (data.hasExtra("returnKey1")) {
            Toast.makeText(this, data.getExtras().getString("returnKey1"),
                Toast.LENGTH_SHORT).show();
        }
    }
}
</strong>
</pre>

<h1>3. Registering for intents via intent filters</h1>

- Intent được sử dụng đẻ báo hiệu cho hệ thống rằng một event đã xẩy ra.
- Intent thường mô tả hành động cần được thực hiện và cung cấp data trên đó một hành động như vậy cần dùng.
VD: Ứng dụng có thể khởi cạy một browser sử dụng URL thông qua một intent
<pre>
<strong>
String url = "http://www.vogella.com";
Intent i = new Intent(Intent.ACTION_VIEW);
i.setData(Uri.parse(url));
startActivity(i);
</strong>
</pre>

- Để hệ thông xác định thành phần có thể tương tác với intent, thì mỗi thành phần đó phải đăng ký một intent filter cho một hành động cụ thể và dữ liệu cụ thể.
- Intent filter chỉ rõ kiểu loại intent mà một activity, service, broadcast receiver có thể đắp lại bằng cách khai báo các khả năng của một thành phần.
- Có thể đăng ký intent filter tĩnh trong file AndroidManifest.xml và động trong code của một broadcast receiver.
- Nếu một intent được gửi tới hệ thống, hệ thống sẽ chạy một bộ xác định receiver. Nó sử dụng data trong intent, nếu có nhiều thành phần cùng đăng ký intent filter giống nhau thì người dùng sẽ chọn.
- Nếu một thành phần mà không định nghĩa 

<strong>3.1. Example: Register an activity as browser</strong>
VD: Đăng ký một Activity cho một intent , nó được kích hoạt khi ai đó muốn mở webpage.
<pre lang="xml">
<strong>

<activity android:name=".BrowserActivitiy"
          android:label="@string/app_name">
  <intent-filter>
     <action android:name="android.intent.action.VIEW" />
     <category android:name="android.intent.category.DEFAULT" />
     <data android:scheme="http"/>
  </intent-filter>
</activity>

</strong>
</pre>

<strong>3.2. Example: Register an activity for the share intent</strong>
VD: Đăng ký một activity cho intent ACTION_SEND, nó tự khai bảo chỉ phù hợp với text/plain
<pre lang="xml">
{{
<strong>

<activity
    android:name=".ActivityTest"
    android:label="@string/app_name" >
    <intent-filter>
      <action android:name="android.intent.action.SEND" />

      <category android:name="android.intent.category.DEFAULT" />

      <data android:mimeType="text/plain" />

    </intent-filter>

</activity>

</strong>
}}
</pre>












