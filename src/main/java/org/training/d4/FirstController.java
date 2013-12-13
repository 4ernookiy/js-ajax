package org.training.d4;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.training.d4.bean.Message;
import org.training.d4.dao.DaoException;
import org.training.d4.dao.DaoFactory;

import com.google.gson.Gson;

/**
 * The Class FirstController.
 */
public class FirstController extends AbstractController {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(FirstController.class);

	/*
	 * (non-Javadoc)
	 * @see org.training.d4.AbstractController#performTask(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void performTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// try {
			// 	Thread.sleep(1000);
			// } catch (InterruptedException e) {
			// 	e.printStackTrace();
			// }
			String action = request.getParameter("action");
			System.out.println(action);
			String json = null;
			if ("getList".equals(action)) {
				List<Message> messages = DaoFactory.getFactory().getIMessageDao().findAll();
				Gson gson = new Gson();
				json = gson.toJson(messages);
			}
			// System.out.println(json);
			// Type listMessageType = new TypeToken<List<Message>>() { }
			// .getType();
			// List<Message> listFromJson = gson.fromJson(json,
			// listMessageType);
			// response.setCharacterEncoding("UTF-8");
			response.setContentType("application/x-json");
			response.getWriter().write(json);
			System.out.println(json);
		} catch (DaoException e) {
			LOG.error(e);
		}
	}
}
