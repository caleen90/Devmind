package ro.calin;

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

    public static class AlreadyOnList extends Errors{
        public AlreadyOnList(){
            super();
        }

        public AlreadyOnList(String str){
            super(str);
        }
    }
}
