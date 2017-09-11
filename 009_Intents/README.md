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
