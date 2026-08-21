class Result<T> {
    private boolean success;
    private String message;
    private T data;

    public Result(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}

public class GenericResultDemo {
    public static void main(String[] args) {

        // Result<String>
        Result<String> result1 =
                new Result<>(true, "取得文字資料成功", "Hello Java");

        String text = result1.getData();

        System.out.println("success: " + result1.isSuccess());
        System.out.println("message: " + result1.getMessage());
        System.out.println("data: " + text);

        System.out.println("--------------------");

        // Result<Integer>
        Result<Integer> result2 =
                new Result<>(true, "取得整數資料成功", 100);

        Integer number = result2.getData();

        System.out.println("success: " + result2.isSuccess());
        System.out.println("message: " + result2.getMessage());
        System.out.println("data: " + number);

        System.out.println("--------------------");

        // 失敗時 data 必須為 null
        Result<String> result3 =
                new Result<>(false, "資料取得失敗", null);

        System.out.println("success: " + result3.isSuccess());
        System.out.println("message: " + result3.getMessage());
        System.out.println("data: " + result3.getData());
    }
}