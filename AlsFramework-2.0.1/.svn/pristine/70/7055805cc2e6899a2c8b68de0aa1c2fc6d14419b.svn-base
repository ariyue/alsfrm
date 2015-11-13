package com.als.frm.module.frm.act;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.util.PathUtil;
import com.als.web.action.BasAction;
import com.als.web.action.IAction;
import com.als.web.action.type.Action;
import com.als.web.action.type.ActionMetod;

@Action("autoui")
public class AutoUIAction extends BasAction implements IAction {

	@Override
	public String getTransCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object init(AppData appData) {
		// TODO Auto-generated method stub
		return null;
	}

	@ActionMetod("listpage")
	public Object getListPage(AppData appData)throws Exception  {
		
		/*HttpServletRequest request = this.getActionContext().getRequest();
		String filePath = PathUtil.getRootDiskPath(request) + "ctr/len/view/auto/ListCode.txt";
		HttpServletResponse response  = this.getActionContext().getResponse();
		this.downLoad(filePath, response, false);
		return null;*/
		
		
		HttpServletRequest request = this.getActionContext().getRequest();
		File f = new File(PathUtil.getRootDiskPath(request) + "ctr/len/view/auto/ListCode.txt");
		if (f !=null){
			String c = readTxt(f);
			
			System.out.println(c);
			
			return c;
		}
		return "";
	}
	
	
	public void downLoad(String filePath, HttpServletResponse response, boolean isOnLine) throws Exception {
        File f = new File(filePath);
        if (!f.exists()) {
            response.sendError(404, "File not found!");
            return;
        }
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
        byte[] buf = new byte[1024];
        int len = 0;

        response.reset(); // 非常重要
        if (isOnLine) { // 在线打开方式
            URL u = new URL("file:///" + filePath);
            response.setContentType(u.openConnection().getContentType());
            response.setHeader("Content-Disposition", "inline; filename=" + f.getName());
            // 文件名应该编码成UTF-8
        } else { // 纯下载方式
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename=" + f.getName());
        }
        OutputStream out = response.getOutputStream();
        while ((len = br.read(buf)) > 0)
            out.write(buf, 0, len);
        br.close();
        out.close();
    }

	/**
	 * 读取 Txt 文件
	 * 
	 * @param file
	 * @return
	 */
	public static String readTxt(File file) throws Exception {
		StringBuffer txtValueList = new StringBuffer();
		String encoding = "UTF-8";
		if (file.exists() && file.canRead()
				&& (file.getName().lastIndexOf(".txt") > 0)) {
			InputStreamReader read = new InputStreamReader(new FileInputStream(
					file), encoding);
			BufferedReader buffer = new BufferedReader(read);
			String lineTxt = null;
			while ((lineTxt = buffer.readLine()) != null) {
				txtValueList.append(lineTxt + "\r\n");
			}
			if (read != null) {
				read.close();
			}
		}
		return txtValueList.toString();
	}

}
