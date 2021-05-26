package nik.iant.physicscafe;

import android.content.res.Configuration;
import android.graphics.pdf.PdfDocument;

import org.w3c.dom.Document;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

public class npdf {
   /* public boolean create (String htmlText, String absoluteFilePath) {
        try {
            Document document = new Document(PageSize.LETTER);
            PdfDocument mydoc = new PdfDocument();
            mydoc.a
            PdfWriter pdfWriter = PdfWriter.getInstance
                    (document, new FileOutputStream(absoluteFilePath));
            document.open();

            // Fixing xhtml tag
            Tidy tidy = new Tidy(); // obtain a new Tidy instance
            tidy.setXHTML(true); // set desired config options using tidy setters
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            tidy.setCharEncoding(Configuration.UTF8);
            tidy.parse(new ByteArrayInputStream(htmlText.getBytes(), output);
            String preparedText = output.toString("UTF-8");

            Log.i("CHECKING", "JTidy Out: " + preparedText);

            InputStream inputStream = new ByteArrayInputStream(preparedText.getBytes());
            XMLWorkerHelper.getInstance().parseXHtml(pdfWriter, document,
                    inputStream, null, Charset.forName("UTF-8"), new MyFont());

            document.close();
            return true;
        } catch (Exception e) {
            File file = new File(absoluteFilePath);
            if(file.exists()) {
                boolean isDeleted = file.delete();
                Log.i("CHECKING", "PDF isDeleted: " + isDeleted);
            }
            LOGGER.error("Exception: " + e.getMessage());
            e.printStackTrace();
            return false;
        }

    }*/
}
