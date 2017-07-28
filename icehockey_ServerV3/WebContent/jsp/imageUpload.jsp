<%@page import="org.apache.commons.fileupload.FileUploadException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);

	if (isMultipart) {
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig().getServletContext();

		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");

		try {
			List<FileItem> items = upload.parseRequest(request);

			for (FileItem item : items) {
				if (item.isFormField()) {
					System.out.println(item.getFieldName());
					System.out.println(item.getString("utf-8"));
				} else {
					System.out.println(item.getFieldName());
					System.out.println(item.getName());
					System.out.println(item.getContentType());
					System.out.println(item.getSize());

					String rootPath = servletContext.getRealPath("//");
					//System.out.println(rootPath);
					//String savePath = rootPath + File.separator + "upload";
					String savePath="C:"+File.separator+"upload";
					File fileSaveFolder = new File(savePath);
					if (!fileSaveFolder.exists()) {
						fileSaveFolder.mkdir();
					}
					File tempfile = new File(item.getName());
					String saveFileName = savePath + File.separator + tempfile.getName();
					System.out.println(saveFileName);

					File uploadedFile = new File(saveFileName);
					item.write(uploadedFile);
					saveFileName = saveFileName.replace("\\", "\\\\");
					System.out.println(saveFileName);

					response.setContentType("text/html;charset=utf-8");
					PrintWriter out1 = response.getWriter();

					//out1.print("<script>parent.callback('//upload//"+tempfile.getName()+"');</script>");
					out1.print("<script>parent.callback('" + saveFileName + "');</script>");

				}
			}

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>