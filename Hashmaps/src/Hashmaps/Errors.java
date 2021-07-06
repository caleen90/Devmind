package Hashmaps;

public class Errors extends RuntimeException{
    public Errors(){
        super();
    }

    public Errors(String str){
        super(str);
    }

    public static class NotFound extends Errors{
        public NotFound(){
            super();
        }

        public NotFound(String str){
            super(str);
        }
    }

    public static class AlreadyRented extends Errors{
        public AlreadyRented(){
            super();
        }

        public AlreadyRented(String str){
            super(str);
        }
    }
}
