package com.hndysf.servlet.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.hndysf.entity.Movie;
import com.hndysf.service.MovieService;
import com.hndysf.util.FileUploadUtils;

/**
 * Servlet implementation class AddMovieServlet
 */
@WebServlet("/AddMovieServlet")
public class AddMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//将上传的数据封装
		Movie m=new Movie();
		Map<String,String> map=new HashMap<String,String>();
		
		DiskFileItemFactory dfif=new DiskFileItemFactory();
		//设置临时文件存储位置
		dfif.setRepository(new File(this.getServletContext().getRealPath("/temp")));
		//设置上传文件缓存大小为10秒
		dfif.setSizeThreshold(1024*1024*10);
		//创建上传组件
		ServletFileUpload upload=new ServletFileUpload(dfif);
		//处理上传文件中文乱码
		upload.setHeaderEncoding("utf-8");
		try {
			//解析request得到所有的FileItem
			List<FileItem> items=upload.parseRequest(request);
			//遍历所有FileItem
			for(FileItem item:items) {
				//判断当前是否是上传组件
				if(item.isFormField()) {
					//不是上传组件
					String fieldName=item.getFieldName();//获取组件名称
					String value=item.getString("utf-8");
					map.put(fieldName, value);
				}else {
					//是上传组件,得到上传文件真实名称
					String fileName=item.getName();
					fileName=FileUploadUtils.subFileName(fileName);
					
					//得到随机名称
					String randomName=FileUploadUtils.generateRandonFileName(fileName);
					
					//得到随机目录
					String randomDir=FileUploadUtils.generateRandomDir(randomName);
					System.out.println("randomDir="+randomDir);
					//图片存储父目录
					String imgurl_parent="/client/image"+randomDir;
					System.out.println("imgurl_parent="+imgurl_parent);
					
					File parentDir=new File(this.getServletContext().getRealPath(imgurl_parent));
					//验证目录是否存在，如果不存在，创建
					if(!parentDir.exists()) {
						parentDir.mkdirs();
					}
					String imgurl=imgurl_parent+"/"+randomName;
					String imgurl_pic1=imgurl_parent+"/"+randomName;
					String imgurl_pic2=imgurl_parent+"/"+randomName;;
					System.out.println("imgurl="+imgurl);
					map.put("movie_img", imgurl);
					map.put("movie_pic1", imgurl_pic1);
					map.put("movie_pic2", imgurl_pic2);
					
					IOUtils.copy(item.getInputStream(), new FileOutputStream(new File(parentDir,randomName)));
					item.delete();
				}
			}
		}catch(FileUploadException  e) {
			e.printStackTrace();
		}
		
		
		
		try {
			//将数据封装到JavaBean中
			BeanUtils.populate(m, map);
		}catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		MovieService mService=new MovieService();
		try {
			int count=mService.addMovie(m);
			System.out.println("count="+count);
			response.getWriter().write("添加成功！");
			response.sendRedirect(request.getContextPath()+ "/AllMovieInfoServlet");
			return;
		}catch(Exception e) {
			e.printStackTrace();
			response.getWriter().write("添加失败");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
