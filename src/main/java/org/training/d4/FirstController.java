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
		// TODO Auto-generated method stub
		try {
//			try {
//				Thread.sleep( 1000 );
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			List<Message> messages = DaoFactory.getFactory().getIMessageDao().findAll();
			// Message mes =
			// Message message =
			// DaoFactory.getFactory().getIMessageDao().findByID(1);
			String action = request.getParameter("action");
			System.out.println(action);
			System.out.println(request.getParameter("name1"));
			Gson gson = new Gson();
			String json = gson.toJson(messages);
			// System.out.println(json);
			// Type listMessageType = new TypeToken<List<Message>>() { }
			// .getType();
			// List<Message> listFromJson = gson.fromJson(json,
			// listMessageType);
			System.out.println(json);
			response.setContentType("application/x-json");
			// response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		} catch (DaoException e) {
			LOG.error(e);
		}
	}
}
