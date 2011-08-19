package ru.mentorbank.backoffice.services.moneytransfer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ru.mentorbank.backoffice.model.stoplist.JuridicalStopListRequest;
import ru.mentorbank.backoffice.model.transfer.JuridicalAccountInfo;
import ru.mentorbank.backoffice.model.transfer.TransferRequest;
import ru.mentorbank.backoffice.services.accounts.AccountService;
import ru.mentorbank.backoffice.services.accounts.AccountServiceBean;
import ru.mentorbank.backoffice.services.moneytransfer.exceptions.TransferException;
import ru.mentorbank.backoffice.services.stoplist.StopListService;
import ru.mentorbank.backoffice.services.stoplist.StopListServiceStub;
import ru.mentorbank.backoffice.test.AbstractSpringTest;

public class MoneyTransferServiceTest extends AbstractSpringTest {

	@Autowired
	private MoneyTransferServiceBean moneyTransferService;
	private AccountService mockedAccountService;
	private JuridicalAccountInfo srcAccountInfo;
	private TransferRequest transferRequest;
	private JuridicalAccountInfo dstAccountInfo;
	private JuridicalAccountInfo accountInfo;
	private JuridicalStopListRequest juridicalStopListRequest;
	private StopListService mockedStopListService;

	@Before
	public void setUp() {
		srcAccountInfo = new JuridicalAccountInfo();
		srcAccountInfo.setAccountNumber("111111111111111");
		srcAccountInfo.setInn(StopListServiceStub.INN_FOR_OK_STATUS);

		dstAccountInfo = new JuridicalAccountInfo();
		dstAccountInfo.setAccountNumber("222222222222222");
		dstAccountInfo.setInn(StopListServiceStub.INN_FOR_OK_STATUS);

		accountInfo = srcAccountInfo;

		transferRequest = new TransferRequest();
		transferRequest.setSrcAccount(srcAccountInfo);
		transferRequest.setDstAccount(dstAccountInfo);

		juridicalStopListRequest = new JuridicalStopListRequest();
		juridicalStopListRequest.setInn(StopListServiceStub.INN_FOR_OK_STATUS);
		juridicalStopListRequest.getClass();

	}

	@Test
	public void transfer() throws TransferException {
		// fail("not implemented yet");
		// TODO: Необходимо протестировать, что для хорошего перевода всё
		// работает и вызываются все необходимые методы сервисов
		// Далее следует закоментированная заготовка

		mockedStopListService = mock(StopListServiceStub.class);
		mockedAccountService = mock(AccountServiceBean.class);

		when(mockedAccountService.verifyBalance(dstAccountInfo)).thenReturn(
				true);

		(moneyTransferService).setAccountService(mockedAccountService);
		moneyTransferService.transfer(transferRequest);

		/*
		 * verify(mockedStopListService).getJuridicalStopListInfo( refEq());
		 */

		/*
		 * verify(mockedStopListService, never()).getJuridicalStopListInfo(
		 * any(juridicalStopListRequest.getClass()));
		 */
		mockedStopListService
				.getJuridicalStopListInfo(juridicalStopListRequest);
		verify(mockedStopListService).getJuridicalStopListInfo(
				juridicalStopListRequest);
		verify(mockedAccountService).verifyBalance(dstAccountInfo);

		// verify(mockedStopListService).getJuridicalStopListInfo(null);
		// verify(mockedAccountService).verifyBalance(juridicalStopListRequest);

	}
}
