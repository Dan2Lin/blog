package com.linda.blog.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;

/**
 * Servlet implementation class FileUploader
 */
public class FileUploader {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fileHomePath = "/upload/images";// 上传文件保存在哪个路径下
		String viewPath = "http://118.24.20.254:8080/freemarker/upload/images/";// 图片的访问路径
		String fileEndswiths = ".gif,.jpeg,.jpg,.png";
		long fileMaxSize = 10;// 单位：m
		OutputStream os = null;
		InputStream is = null;
		String newFilePathStr = null;
		try {
			List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			for (FileItem item : items) {
				if (!item.isFormField()) {// 当 item is not 普通表单字段
					// 1.验证是否是图片
					boolean isImg = false;
					String oldFileName = item.getName();
					String[] fileEnds = fileEndswiths.split(",");
					for (String str : fileEnds) {
						String oldName = oldFileName.toLowerCase();
						if (oldName.endsWith(str)) {
							isImg = true;
							break;
						}
					}
					if (!isImg) {
						// 抛出 Only support gif,jpeg,png!
						this.returnError(response, "Only support " + fileEndswiths + "!");
						return;
					}
					// 2.验证图片大小是否超限制
					long fileSize = item.getSize();
					if (fileSize > (fileMaxSize * 1024 * 1024)) {
						// 抛出 文件不能超过 fileMaxSize m
						this.returnError(response, "The file cannot exceed  " + fileMaxSize + " M");
						return;
					}
					// 3.创建新的文件名和路径
					String fileExt = oldFileName.substring(oldFileName.lastIndexOf(".") + 1).toLowerCase();
					String newFileName = String.valueOf(new Date().getTime()) + "_" + new Random().nextInt(1000) + "."
							+ fileExt;

					String projectNameString = StringUtils.replace(request.getContextPath().replace("\\", "/"), "//",
							"/");

					// windows
					String fileHomePath1 = request.getSession().getServletContext().getRealPath("/").replace("\\", "/");
					fileHomePath = fileHomePath1.replace(projectNameString, "") + "freemarker/upload/";

					// liunx
					// fileHomePath=request.getSession().getServletContext().getRealPath("/").replace(projectNameString,
					// "")+"freemarker/upload/";

					viewPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
							+ "/freemarker/upload/";
					File newFileHome = new File(fileHomePath);
					if (!newFileHome.exists()) {
						newFileHome.mkdirs();
					}
					File newFile = new File(fileHomePath + newFileName);
					os = new FileOutputStream(newFile);
					is = item.getInputStream();
					byte buf[] = new byte[1024 * 4];// 每次夺取的字节数
					int length = 0;
					while ((length = is.read(buf)) > 0) {
						os.write(buf, 0, length);
					}
					if (newFilePathStr == null) {
						newFilePathStr = viewPath + newFileName;
					} else {
						newFilePathStr = newFilePathStr + "," + viewPath + newFileName;
					}
				}
			}
		} catch (FileUploadException e) {
			this.returnError(response, "Failed to upload!");
			return;
		} finally {
			if (os != null) {
				os.close();
			}
			if (is != null) {
				is.close();
			}
		}
		this.returnMsg(response, newFilePathStr, "File is uploaded successfully.");
	}

	/**
	 * 处理上传成功后的返回值dave20141125
	 * 
	 * @param response
	 * @param code
	 * @param data
	 * @param msg
	 * @throws IOException
	 */
	private void returnMsg(HttpServletResponse response, String path, String msg) throws IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		ArrayList<String>  strArray = new ArrayList<String> ();
		strArray.add(path);
		result.put("errno", 0);
		result.put("msg", msg);
		result.put("data", strArray);

		JSONObject json = JSONObject.fromObject(result);
		HttpServletResponse resp = response;
		resp.setHeader("content-type", "text/html;charset=utf-8");// 通知浏览器 使用 utf-8 编码
		resp.setContentType("application/x-json");
		PrintWriter out = resp.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}

	/**
	 * 处理上传失败后的返回值dave20141125
	 * 
	 * @param response
	 * @param code
	 *            * @param msg
	 * @throws IOException
	 */
	private void returnError(HttpServletResponse response, String msg) throws IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("errno", -1);
		result.put("msg", msg);
		JSONObject json = JSONObject.fromObject(result);
		HttpServletResponse resp = response;
		resp.setHeader("content-type", "text/html;charset=utf-8");// 通知浏览器 使用 utf-8 编码
		resp.setContentType("application/x-json");
		PrintWriter out = resp.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}
}
