package search.utils;

public class Arguments {
    private static Arguments arguments;

    private Arguments() { }

    public static Arguments getArguments() {
        if (arguments == null) {
            arguments = new Arguments();
        }

        return arguments;
    }

    // data: holds the value of command line argument/flag/option "--data"
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
