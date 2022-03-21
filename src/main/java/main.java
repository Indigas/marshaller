import javax.xml.bind.JAXBException;

public class main {

    public static void main(String[] args) throws JAXBException {

        MyMarshaller marsh = new MyMarshaller();

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {

                   try {
                        marsh.marshall();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {

                        marsh.marshall();
                    } catch (JAXBException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        b.start();
        a.start();

    }
}
