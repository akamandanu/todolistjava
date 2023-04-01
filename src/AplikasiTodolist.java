public class AplikasiTodolist {

    public static String[] data = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        viewShowTodoList();

    }

    public static String input(String info) {

        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;

    }

    public static void showTodoList() {

        for (var i = 0; i < data.length; i++) {
            var todo = data[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + " . " + todo);
            }
        }

    }

    public static void addTodoList(String todo) {

        var isFull = true;

        for (var i = 0; i < data.length; i++) {
            if (data[i] == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            String[] temp = data;
            data = new String[data.length * 2];

            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }

        for (var i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = todo;
                break;
            }
        }

    }

    public static boolean removeTodoList(Integer number) {

        if ((number - 1) >= data.length) {
            return false;
        } else if (data[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < data.length; i++) {
                if (i == (data.length - 1)) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }

    public static void viewShowTodoList() {

        while (true) {
            showTodoList();

            System.out.println("MENU");
            System.out.println("1. Tambah Todo List");
            System.out.println("2. Remove Todo List");
            System.out.println("3. Keluar");

            String input = input("pilih");

            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals(("2"))) {
                viewRemoveTodoList();
            } else if (input.equals("3")) {
                break;
            } else {
                System.out.println("Pilihan tidak di mengerti");
            }
        }

    }

    public static void viewAddTodoList() {

        System.out.println("Menambah Todolist");

        String input = input("Todo (X jika Batal)");

        if (input.equals("X")) {
            //batal
        } else {
            addTodoList(input);
        }

    }

    public static void viewRemoveTodoList() {
        String input = input("Nomor yang akan dihapus (X jika Batal)");

        if (input.equals("X")) {
            //batal
        } else {
            boolean success = removeTodoList(Integer.valueOf(input));
            if (!success) {
                System.out.println("Gagal menghapus TodoList: " + input);
            }
        }
    }

}
