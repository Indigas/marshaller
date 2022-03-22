import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;

public class MyMarshaller {
    private  Marshaller marshaller;
    private static JAXBContext context;

    static {
        try {
            context = JAXBContext.newInstance(Book.class);
            //marshaller=context.createMarshaller();

        } catch (JAXBException e) {
            System.out.println("chyba >>>> "+e.getMessage());
        }

    }

    MyMarshaller() throws JAXBException {
        marshaller=context.createMarshaller();
    }

    public void marshall() throws JAXBException {
        Book book = new Book();
        book.setId(2L);
        book.setAuthor("Marek");
        book.setName("Sunshine");

        Writer writer = new StringWriter();


        //marshaller=context.createMarshaller();

        // possible fix with synchronized for thread-safe operation
        //synchronized (marshaller) {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            try {
                marshaller.marshal(book, writer);
            } catch (Exception e) {
                e.printStackTrace();
                //   this.marshall();

            }
       // }
    }
}
