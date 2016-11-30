package add.service;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	service = AddService.class
)
public class AddServiceImpl implements AddService {

	@Override
	public int add(int a, int b) {
		return a + b;
	}

}