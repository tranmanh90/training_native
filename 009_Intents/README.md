1.1. What is intents?
- Intent là bản tin không đồng bộ, cho phép các thành phần ứng dụng yêu cầu chức năng từ các thành phần android khác.
- Intent cho phép tương tác giữa các thành phần trong 1 ứng dụng và với các thành phần của ứng dụng khác.
- Một intent có thể chứa dữ liệu thông qua một Bundle, dữ liệu này sẽ được các thành phần nhận sử dụng.

1.2. Starting activities or services
- Để khởi chạy một Activity ta sử dụng phương thức startActivity(intent), phương thức này được định nghĩa trong đối tượng Context mà Activity kế thừa.
![alt text](http://www.vogella.com/tutorials/AndroidIntent/img/xstartactivityviaintent10.png.pagespeed.ic.XIxbBb_YEg.webp)

Intent i = new Intent(this, ActivityTwo.class); <br/>
startActivity(i);

- Để khởi chạy một service ta sử dụng hàm startService(Intent)

1.3. Sending out explicit or implicit intents
- Android hỗ trợ Intent tường minh và không tường minh.
- Intent tường minh là một ứng dụng sẽ xác định thành phần đích muốn truyền intent tới.
- Intent không tường minh là ứng dụng sẽ hỏi hế thống đánh giá xem những thành phần nào đã đăng ký dựa trên dữ liệu của intent.
