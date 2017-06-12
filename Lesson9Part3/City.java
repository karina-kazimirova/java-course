package Lesson9Part3;

/**
 * Created by Sve on 12.06.2017.
 */
public class City {


    public void addName(){
        Avenue avenue1 = new Avenue();
        avenue1.setName("Gartkyl");
        avenue1.print();

        Avenue avenue2 = new Avenue();
        avenue2.setName("KCKmckm");
        avenue2.print();


        Street street1 = new Street();
        street1.setName("JIjkokvf");
        street1.print();

        Street street2 = new Street();
        street2.setName("Lvrgtgge");
        street2.print();


        Plaza plaza1 = new Plaza();
        plaza1.setName("Ofmkmkv");
        plaza1.print();

        Plaza plaza2 = new Plaza();
        plaza2.setName("Pklkmkm.");
        plaza2.print();



    }





    public class Avenue{
        private String name;

        public void setName(String newName){
            this.name = newName;
        }
        public String getName() {
            return name;
        }

        public String toString(){
            return this.name;
        }

        public void print(){
            System.out.println("Проспект " + getName());
        }


    }

    public class Street{
        private String name;

        public void setName(String newName){
            this.name = newName;
        }
        public String getName() {
            return name;
        }

        public String toString(){
            return this.name;
        }

        public void print(){
            System.out.println("Улица " + getName());
        }

    }

    public class Plaza{

        private String name;

        public void setName(String newName){
            this.name = newName;
        }
        public String getName() {
            return name;
        }

        public String toString(){
            return this.name;
        }

        public void print(){
            System.out.println("Площадь " + getName());
        }

    }
}
