package com.vikas.restws;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.container.AsyncResponse;
import org.springframework.stereotype.Service;
import com.vikas.restws.modal.ChecksList;

@Service
public class CheckProcessorImpl implements CheckProcessor {

	@Override
	public void processChecks(AsyncResponse response, ChecksList checkslist) {
		new Thread(() -> {
			try {
				if (checkslist == null || checkslist.getChecks() == null || checkslist.getChecks().size() == 0) {
					response.resume(new BadRequestException());
				}
				Thread.sleep(10000);
				response.resume(true);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

}
