package p1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

	public class PdfText {

		public static void main(String[] args) {

			Document document = new Document();

			try {
				PdfWriter.getInstance(document, new FileOutputStream(
						"MyFirstDynamic.pdf"));

				document.open();
				document.add(new Paragraph(
						"iText Core is the library that allows you to create, process and edit PDF documents"));
				document.close();
				
			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

