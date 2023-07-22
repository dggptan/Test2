import java.io.*;
class Test{
    public static void main(String[] args){
        Demo object = new Demo(1, "serialization");
        String filename = "file.ser";

        //serialization
        try{
            //saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            //method for serialization of object
            out.writeObject(object);

            out.close();
            file.close();

            System.out.println("Object has been serializaed");
        }
        catch(IOException ex){
            System.out.println("IOException has been caught");
        }

        Demo object1 = null;
        //deseriaization
        try{
            //reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file); 

            //method for deserialization of object
            object1 = (Demo)in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized");
            System.out.println("a = " + object1.a);
            System.out.println("b = " + object1.b);
        }

        catch(IOException ex){
            System.out.println("IOException has been caught");
        }
        catch(ClassNotFoundException ex){
            System.out.println("ClassNotFoundException has been caught");
        }
    }
}