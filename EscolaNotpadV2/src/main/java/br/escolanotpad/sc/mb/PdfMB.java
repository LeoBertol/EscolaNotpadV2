package br.escolanotpad.sc.mb;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.swing.border.TitledBorder;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.escolanotpad.sc.model.entity.Agenda;
import br.escolanotpad.sc.model.AgendaRN;


import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.BaseFont;

import com.itextpdf.text.pdf.draw.LineSeparator;

@ManagedBean
@RequestScoped
public class PdfMB {
	
	private String usuarioId;
	
	
	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public static final Font BOLD_UNDERLINED = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD | Font.UNDERLINE);
	public static final Font NORMAL = new Font(FontFamily.HELVETICA, 24, Font.BOLDITALIC | Font.getStyleValue("text-align: center;"));

	public void gerarPdf(String usuarioId) {
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) 
				context.getExternalContext().getResponse();
		
		try {
			
			Document document = new Document();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, baos);
			
			
			document.open();
			
			document.addTitle("Sua agenda Escola NotPad");
					    
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			
			AgendaRN agendaRN = new AgendaRN();
			
			List<Agenda> agendas = agendaRN.listaAgendaPorProfessor(usuarioId);
			if(agendas.isEmpty() == true){
				agendas = agendaRN.listaAgendaPorAluno(usuarioId);
			}
			
			Paragraph p1 = new Paragraph("Sua Agenda", NORMAL);
			p1.setAlignment(Element.ALIGN_CENTER);
			document.add(p1);
			
			//Criando a tabela
			PdfPTable table = new PdfPTable(4);
			
			table.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			BaseColor colorHeader = new BaseColor(135,206,250);
			
		    PdfPCell headerAmbiente = new PdfPCell(new Paragraph("Ambiente"));
		    headerAmbiente.setBorder(Rectangle.NO_BORDER);
		    headerAmbiente.setHorizontalAlignment(Element.ALIGN_CENTER);
		    headerAmbiente.setVerticalAlignment(Element.ALIGN_CENTER);
		    //headerAmbiente.setBackgroundColor(colorHeader);
		    headerAmbiente.setBorderWidthBottom(Rectangle.BOTTOM);
		    headerAmbiente.setBorderWidthBottom(1);
		    headerAmbiente.setBorderWidthTop(Rectangle.TOP);
		    headerAmbiente.setBorderWidthTop(1);
		    headerAmbiente.setPaddingBottom(5);
		    table.addCell(headerAmbiente);
		    
		    PdfPCell headerProfessor = new PdfPCell(new Paragraph("Tutor"));
		    headerProfessor.setBorder(Rectangle.NO_BORDER);
		    headerProfessor.setHorizontalAlignment(Element.ALIGN_CENTER);
		    headerProfessor.setVerticalAlignment(Element.ALIGN_CENTER);
		    //headerProfessor.setBackgroundColor(colorHeader);
		    headerProfessor.setBorderWidthBottom(Rectangle.BOTTOM);
		    headerProfessor.setBorderWidthBottom(1);
		    headerProfessor.setBorderWidthTop(Rectangle.TOP);
		    headerProfessor.setBorderWidthTop(1);
		    headerProfessor.setPaddingBottom(5);
		    table.addCell(headerProfessor);
		  
		    PdfPCell headerTurma = new PdfPCell(new Paragraph("Turma"));
		    headerTurma.setBorder(Rectangle.NO_BORDER);
		    headerTurma.setHorizontalAlignment(Element.ALIGN_CENTER);
		    headerTurma.setVerticalAlignment(Element.ALIGN_CENTER);
		    //headerTurma.setBackgroundColor(colorHeader);
		    headerTurma.setBorderWidthBottom(Rectangle.BOTTOM);
		    headerTurma.setBorderWidthBottom(1);
		    headerTurma.setBorderWidthTop(Rectangle.TOP);
		    headerTurma.setBorderWidthTop(1);
		    headerTurma.setPaddingBottom(5);
		    table.addCell(headerTurma);
		    
		    PdfPCell headerData = new PdfPCell(new Paragraph("Data da aula"));
		    headerData.setBorder(Rectangle.NO_BORDER);
		    headerData.setHorizontalAlignment(Element.ALIGN_CENTER);
		    headerData.setVerticalAlignment(Element.ALIGN_CENTER);
		     //headerData.setBackgroundColor(colorHeader);
		    headerData.setBorderWidthBottom(Rectangle.BOTTOM);
		    headerData.setBorderWidthBottom(1);
		    headerData.setBorderWidthTop(Rectangle.TOP);
		    headerData.setBorderWidthTop(1);
		    headerData.setPaddingBottom(5);
		    table.addCell(headerData);
		    
		    table.setSpacingBefore(15);
		    
		    
		    
		    
		    
		    BaseColor color = new BaseColor(30,144,255);
		    //Repetição para celulas dinamicas
		    for (Agenda a : agendas) {
		    	
		    	
		    	if (color.getRed() == 30) {
		    		color = new BaseColor(135,206,250);
				} else {
					color = new BaseColor(30,144,255);
				}
		    	
		    	PdfPCell nome = new PdfPCell(new Paragraph(a.getAmbiente().getNome()));
		    	nome.disableBorderSide(0);
		    	nome.setBackgroundColor(color);
		    	nome.setBorder(Rectangle.NO_BORDER);
		    	nome.setHorizontalAlignment(Element.ALIGN_CENTER);
		    	nome.setVerticalAlignment(Element.ALIGN_CENTER);
		    	nome.setBorderWidthBottom(Rectangle.BOTTOM);
		    	nome.setBorderWidthBottom(1);
		    	
		    	nome.setPaddingBottom(5);
		    	table.addCell(nome);
		    	
		    	PdfPCell professor = new PdfPCell(new Paragraph(a.getProfessorResponsavel().getNome()));
		    	professor.disableBorderSide(0);
		    	professor.setBackgroundColor(color);
		    	professor.setBorder(Rectangle.NO_BORDER);
		    	professor.setHorizontalAlignment(Element.ALIGN_CENTER);
		    	
		    	professor.setBorderWidthBottom(Rectangle.BOTTOM);
		    	professor.setBorderWidthBottom(1);
		    	
		    	professor.setPaddingBottom(5);
		    	table.addCell(professor);
		    	
		    	PdfPCell turma = new PdfPCell(new Paragraph(a.getTurma().getNome()));
		    	turma.disableBorderSide(0);
		    	turma.setBackgroundColor(color);
		    	turma.setBorder(Rectangle.NO_BORDER);
		    	turma.setHorizontalAlignment(Element.ALIGN_CENTER);
		    	turma.setVerticalAlignment(Element.ALIGN_CENTER);
		    	turma.setBorderWidthBottom(Rectangle.BOTTOM);
		    	turma.setBorderWidthBottom(1);
		    	
		    	turma.setPaddingBottom(5);
		    	table.addCell(turma);
		    	
		    	//Formatando a data
		    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		    	PdfPCell data = new PdfPCell(new Paragraph(sdf.format((a.getData()))));
		    	data.disableBorderSide(0);
		    	data.setBackgroundColor(color);
		    	data.setBorder(Rectangle.NO_BORDER);
		    	data.setHorizontalAlignment(Element.ALIGN_CENTER);
		    	data.setVerticalAlignment(Element.ALIGN_CENTER);
		    	data.setBorderWidthBottom(Rectangle.BOTTOM);
		    	data.setBorderWidthBottom(1);
		    
		    	data.setPaddingBottom(5);
		    	table.addCell(data);
		    	
		    	
		    }
		    
		    document.add(table);
		    
		    document.addAuthor("Escola NotPad");
			
			document.close();
			
			response.setHeader("Expires", "0");
			response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
			
			response.setHeader("Pragma", "public");
			
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline;filename=seu_horario.pdf");
			
			response.setContentLength(baos.size());
			
			OutputStream os = response.getOutputStream();
			baos.writeTo(os);
			os.flush();
			os.close();
			
		} catch (Exception e) {
			System.out.println("Erro ao gerar o pdf!");
			e.printStackTrace();
		}
		context.responseComplete();
	}
	
}
