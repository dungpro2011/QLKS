package qlks.DTO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcelFile {
    private static String pathfile ;

    public static void writeXLSXFile(Vector headerThu, ArrayList<HoaDon> dataThu, Vector headerChi, ArrayList<PhieuNhapHang> dataChi) throws IOException {
        String excelFileName = "D:/QLKS/tk.xlsx";
        String sheetName = "Thu";
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet(sheetName) ;
	
	XSSFRow row = sheet.createRow(0);

	for (int c=0;c < headerThu.size(); c++ ){
            XSSFCell cell = row.createCell(c);
            cell.setCellValue(headerThu.get(c).toString());
	}
        XSSFCell cell;
        int j=1;
        for(HoaDon hd: dataThu){
            row = sheet.createRow(j);
            cell = row.createCell(0);
            cell.setCellValue(hd.getSoHoaDon());
            cell = row.createCell(1);
            cell.setCellValue(hd.getMaNhanVien());
            cell = row.createCell(2);
            cell.setCellValue(hd.getMaKhachHang());
            cell = row.createCell(3);
            cell.setCellValue(hd.getNgayThue());
            cell = row.createCell(4);
            cell.setCellValue(hd.getNgayThanhToan());
            cell = row.createCell(5);
            cell.setCellValue(hd.getTongTien());
            j++;
        }
        
        //Chi
        sheetName = "Chi";
        sheet = wb.createSheet(sheetName) ;

        row = sheet.createRow(0);

        for (int c=0;c < headerChi.size(); c++ ){
            cell = row.createCell(c);
            cell.setCellValue(headerChi.get(c).toString());
        }
        j=1;
        for(PhieuNhapHang pnh: dataChi){
            row = sheet.createRow(j);
            cell = row.createCell(0);
            cell.setCellValue(pnh.getMaNhanVien());
            cell = row.createCell(1);
            cell.setCellValue(pnh.getNgayNhapHang());
            cell = row.createCell(2);
            cell.setCellValue(pnh.getTongTien());
            j++;
        }
        try{
            FileOutputStream fileOut = new FileOutputStream(excelFileName);
            wb.write(fileOut);
            fileOut.flush();
            JOptionPane.showMessageDialog(null, "Đã ghi");
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Chưa ghi");
        }
    }
    
    public static ArrayList<HoaDon> readXLSXFile() throws IOException{
        InputStream ExcelFileToRead = new FileInputStream("D:/QLKS/hd.xlsx");
        XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row; 

	Iterator rows = sheet.rowIterator();
        ArrayList<HoaDon> dshd = new ArrayList<>();
        HoaDon hd;
	while (rows.hasNext()){
            row=(XSSFRow) rows.next();
            Iterator cells = row.cellIterator();
            hd = new HoaDon();
            
            hd.setSoHoaDon(String.valueOf(Double.valueOf(cells.next().toString()).intValue()));
            hd.setSoHopDongThuePhong(String.valueOf(Double.valueOf(cells.next().toString()).intValue()));
            hd.setMaNhanVien(String.valueOf(cells.next()));
            hd.setNgayThanhToan(String.valueOf(cells.next()));
            hd.setTienThuePhong(Double.valueOf(cells.next().toString()).intValue());
            hd.setTienDichVu(Double.valueOf(cells.next().toString()).intValue());
            hd.setTienKhuyenMai(Double.valueOf(cells.next().toString()).intValue());
            hd.setThue(Double.valueOf(cells.next().toString()).intValue());
            hd.setTongTien(Double.valueOf(cells.next().toString()).intValue());
            dshd.add(hd);
	}
        return dshd;
    }

 
	
}

   /**
     * Hàm đọc file excel 
     * @return trả về 1 array chứa thông tin bảng excel theo thứ tự ví dụ:
     * có bảng taikhoan thì ar={id1,pass1,id2,pass2,id3,pass3}. lưu ý kiểu int trong excel đọc ra kiểu double trong java nên cần chuyển từ double qua int
     * @throws IOException
     */
 /*   public static ArrayList ReadFile() throws IOException{
            JFileChooser fs = new JFileChooser(new File("C:/Users/Admin/Desktop"));
                fs.setDialogTitle("open a file");
                fs.setFileFilter(new FileNameExtensionFilter("excel file(*.xls)","xls"));
                fs.setFileFilter(new FileNameExtensionFilter("excel file(*.xlsx)","xlsx"));
            while(true){
                int result = fs.showOpenDialog(null);
                if (result!=JFileChooser.APPROVE_OPTION){
                    return null;
                }
                else{
                    pathfile=fs.getSelectedFile().getAbsolutePath();
                    File f=new File(pathfile);
                    if (fs.getFileFilter().getDescription().equals("excel file(*.xls)")){
                        if (f.renameTo(f)){
                            return readXLSFile();
                        }else{
                            JOptionPane.showMessageDialog(null, "hình như file đang mở!");
                            continue;
                        }
                    }
                    if (fs.getFileFilter().getDescription().equals("excel file(*.xlsx)")){
                        if (f.renameTo(f)){
                            return readXLSXFile();
                        }else{
                            JOptionPane.showMessageDialog(null, "hình như file đang mở!");
                            continue;
                        }
                    }
                }
                return null;
            }
        }
	private static ArrayList readXLSFile() throws IOException{
		InputStream ExcelFileToRead = new FileInputStream(pathfile);
		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);

		HSSFSheet sheet=wb.getSheetAt(0);
		HSSFRow row; 
		HSSFCell cell;

		Iterator rows = sheet.rowIterator();
                
                ArrayList array=new ArrayList();
		while (rows.hasNext())
		{
			row=(HSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			
			while (cells.hasNext())
			{
				cell=(HSSFCell) cells.next();
				if (cell.getCellType() == CellType.STRING)
				{
                                    array.add(cell.getStringCellValue());
				}
				else if(cell.getCellType() == CellType.NUMERIC)
				{
                                    array.add(cell.getNumericCellValue());
				}
				else
				{
					//U Can Handel Boolean, Formula, Errors
				}
			}
		}
                JOptionPane.showMessageDialog(null, "đọc file xls thành công");
            return array;
	}
	
	private static void writeXLSFile(Vector headerThu, ArrayList<HoaDon> dataThu, Vector headerChi, ArrayList<PhieuNhapHang> dataChi) throws IOException {
		String excelFileName = pathfile;//name of excel file

		String sheetName = "Thu";//name of sheet

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName) ;

                CellStyle cellStyle = wb.createCellStyle();
                cellStyle.setDataFormat(wb.createDataFormat().getFormat("yyyy/m/dd h:mm"));
                
		//iterating r number of rows
		
		HSSFRow row = sheet.createRow(0);//hàng này là header
                HSSFCell cell;
		//iterating c number of columns
		for (int c=0;c < headerThu.size(); c++ ){          
                    cell = row.createCell(c);
                    cell.setCellValue(headerThu.get(c).toString());
                }
                int i=0;
                int j=1;
                for(HoaDon hd: dataThu){
                    row = sheet.createRow(j);
                    i=0;
                    cell = row.createCell(i);
                    cell.setCellValue(hd.getSoHoaDon());
                    i++;
                    cell = row.createCell(i);
                    cell.setCellValue(hd.getMaNhanVien());
                    i++;
                    cell = row.createCell(i);
                    cell.setCellValue(hd.getMaKhachHang());
                    i++;
                    cell = row.createCell(i);
                    cell.setCellValue(hd.getNgayThue());
                    i++;
                    cell = row.createCell(i);
                    cell.setCellValue(hd.getNgayThanhToan());
                    i++;
                    cell = row.createCell(i);
                    cell.setCellValue(hd.getTongTien());
                    j++;
                }
                //Chi
                sheetName = "Chi";//name of sheet
                sheet = wb.createSheet(sheetName) ;

                cellStyle = wb.createCellStyle();
                cellStyle.setDataFormat(wb.createDataFormat().getFormat("yyyy/m/dd h:mm"));
                //iterating r number of rows

                row = sheet.createRow(0);//hàng này là header

                //iterating c number of columns
                for (int c=0;c < headerChi.size(); c++ ){
                    cell = row.createCell(c);
                    cell.setCellValue(headerThu.get(c).toString());
                }
                j=1;
                for(PhieuNhapHang pnh: dataChi){
                    row = sheet.createRow(j);
                    i=0;
                    cell = row.createCell(i);
                    cell.setCellValue(pnh.getMaNhanVien());
                    i++;
                    cell = row.createCell(i);
                    cell.setCellValue(pnh.getNgayNhapHang());
                    i++;
                    cell = row.createCell(i);
                    cell.setCellValue(pnh.getTongTien());
                    j++;
                }
		
            FileOutputStream fileOut = new FileOutputStream(excelFileName);
		
            //write this workbook to an Outputstream.
            wb.write(fileOut);
            fileOut.flush();
            fileOut.close();
            JOptionPane.showMessageDialog(null, "ghi file xls thành công");
        }

	
	
	*/
    /*public static boolean WritePDF(ArrayList ar,String[] header,int col) throws FileNotFoundException, DocumentException{
        JFileChooser fs = new JFileChooser();
            fs.setCurrentDirectory(new File("C:/Users/Admin/Desktop"));
            fs.setDialogTitle("save a file");
            fs.setFileFilter(new FileNameExtensionFilter("pdf file(*.pdf)","pdf"));
            boolean co=true;
            while (co==true){
                int result = fs.showSaveDialog(null);
                if (result!=JFileChooser.APPROVE_OPTION){
                    return false;
                }
                else{
                    pathfile=fs.getSelectedFile().getAbsolutePath();
                    File f;
                    if (!pathfile.contains(".pdf")){
                        pathfile+=".pdf";
                    }
                        f=new File(pathfile);
                        if(f.exists()){
                        int me=JOptionPane.showConfirmDialog(null, "File đã tồn tại, bạn có muốn ghi đề lên file cũ");
                        if(me==0){
                            if(f.renameTo(f)) {
                            co=false;
                            PDF(ar,header,col);
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "hình như file đang mở!");
                                continue;
                            }
                        }
                        else continue;
                    }
                    else{
                        co=false;
                    }
                        PDF(ar,header,col);co=false;
                    }
    }
        JOptionPane.showMessageDialog(null, "xuất file pdf thành công");
    return true;
}
    private static void PDF(ArrayList ar,String[] header,int col) throws FileNotFoundException, DocumentException{
        Document doc =new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(pathfile));
        doc.setPageSize(PageSize.A3.rotate());

        doc.open();
        //tạo bảng gồm col cột
        PdfPTable table = new PdfPTable(col);
        //tạo header và add header
        for (int i=0;i<header.length;i++){
            PdfPCell hd = new PdfPCell(new Paragraph(header[i]));
            table.addCell(hd);
        }
        
        //tạo ô dữ liệu
        for (int c=0;c<ar.size();c++){
            String dt=null;
            if (ar.get(c) instanceof Integer){
            int tam= (int) ar.get(c);
            dt= String.valueOf(tam);
            PdfPCell data = new PdfPCell(new Paragraph(dt));
            table.addCell(data);
            }else{
            PdfPCell data = new PdfPCell(new Paragraph((String) ar.get(c)));
            table.addCell(data);
            }
        }
        doc.add(table);
        doc.close();
}*/


/*public static boolean WriteFile(Vector headerThu, ArrayList<HoaDon> dataThu, Vector headerChi, ArrayList<PhieuNhapHang> dataChi) throws IOException{
        
        
        
        JFileChooser fs = new JFileChooser();
            fs.setCurrentDirectory(new File("D:/QLKS"));
            fs.setDialogTitle("save a file");
            fs.setFileFilter(new FileNameExtensionFilter("excel file(*.xls)","xls"));
            fs.setFileFilter(new FileNameExtensionFilter("excel file(*.xlsx)","xlsx"));
            boolean co=true;
            while (co==true){
                int result = fs.showSaveDialog(null);
                if (result!=JFileChooser.APPROVE_OPTION){
                    return false;
                }
                else{
                    pathfile=fs.getSelectedFile().getAbsolutePath();
                    JOptionPane.showConfirmDialog(null, pathfile);
                    File f;
                    
                    
                    if (fs.getFileFilter().getDescription().equals("excel file(*.xls)")){
                        if (!pathfile.contains(".xls")){
                            pathfile+=".xls";
                        }
                        f=new File(pathfile);
                        if(f.exists()){
                            int me=JOptionPane.showConfirmDialog(null, "File đã tồn tại, bạn có muốn ghi đề lên file cũ");
                            if(me==0){
                                if(f.renameTo(f)){
                                    co=false;
                                    writeXLSFile(headerThu,dataThu,headerChi,dataChi);return true;
                                }else{
                                    JOptionPane.showMessageDialog(null, "hình như file đang mở!");
                                    continue;
                                }
                            }
                        else continue;
                    }
                    else{
                        co=false;
                    }
                        writeXLSFile(headerThu,dataThu,headerChi,dataChi);return true;
                    }
                    
                    
                    if (fs.getFileFilter().getDescription().equals("excel file(*.xlsx)")){
                        if (!pathfile.contains(".xlsx")){
                            pathfile+=".xlsx";
                        }
                        f=new File(pathfile);
                        if(f.exists()){
                        int me=JOptionPane.showConfirmDialog(null, "File đã tồn tại, bạn có muốn ghi đề lên file cũ");
                        if(me==0){
                            if(f.renameTo(f)){
                            co=false;
                            writeXLSXFile(headerThu,dataThu,headerChi,dataChi);return true;
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "hình như file đang mở!");
                                continue;
                            }
                        }
                        else continue;
                    }else{
                        co=false;
                    }
                        
                        writeXLSXFile(headerThu,dataThu,headerChi,dataChi);return true;
                    }
                }
            }
            return true;
        }*/