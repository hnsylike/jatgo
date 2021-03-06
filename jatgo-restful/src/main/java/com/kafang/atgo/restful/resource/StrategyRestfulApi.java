package com.kafang.atgo.restful.resource;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kafang.atgo.persistence.db.entity.AgAccount;
import com.kafang.atgo.restful.entity.AgStrategyParamL1;
import com.kafang.atgo.restful.entity.RptNominal;
import com.kafang.atgo.restful.entity.RptStrategy;
import com.kafang.atgo.restful.base.AtgoRestfulApi;
import com.kafang.atgo.restful.dto.rep.ResponseTemplate;
import com.kafang.atgo.restful.service.api.AgAccountService;
import com.kafang.atgo.restful.service.api.AgStrategyParamL1Service;
import com.kafang.atgo.restful.service.api.AgStrategyParamL2Service;
import com.kafang.atgo.restful.service.api.AgStrategyParamL3Service;
import com.kafang.atgo.restful.service.api.RptNominalService;
import com.kafang.atgo.restful.service.api.RptStrategyService;
import com.kafang.atgo.restful.util.CSVUtil;

import lombok.extern.slf4j.Slf4j;

@Path("/strategy")
@Slf4j
@Component
public class StrategyRestfulApi extends AtgoRestfulApi {

	@Autowired
	private AgStrategyParamL3Service ag3Service;

	@Autowired
	private AgStrategyParamL2Service ag2Service;

	@Autowired
	private AgStrategyParamL1Service ag1Service;

	@Autowired
	private AgAccountService accountService;

//	@Autowired
//	private RptActualService rptService;

	@Autowired
	private RptNominalService nominalService;

	@Autowired
	private RptStrategyService strategyService;

	@GET
	@Path("/queryStrategy/{strategyId}")
	@Produces(JSON_UTF8)
	public Response queryStrategy(@PathParam("strategyId") int strategyId) {
		Map<String, Map<String, String>> m = new HashMap<>();
		// Map<String, String> m1 = new HashMap<>();
		Map<Integer, Map<String, String>> accountL3Map = ag3Service.selectById(strategyId);
		Map<Integer, Map<String, String>> accountL2Map = ag2Service.selectByStrategyId(strategyId);
		for (Integer account : accountL2Map.keySet()) {
			if (accountL3Map.containsKey(account)) {
				Map<String, String> paramL3Map = accountL3Map.get(account);
				Map<String, String> paramL2Map = accountL2Map.get(account);
				for (String paramName : paramL2Map.keySet()) {
					if (paramL3Map.containsKey(paramName)) {
						paramL3Map.put(paramName, paramL2Map.get(paramName));
					}
				}
			}
		}
		List<AgStrategyParamL1> accountL1List = ag1Service.selectById(strategyId);
		for (AgStrategyParamL1 agStrategyParamL1 : accountL1List) {
			Integer accountID = agStrategyParamL1.getAccountId();
			if (accountL3Map.containsKey(accountID)) {
				Map<String, String> map = accountL3Map.get(accountID);
				map.put(agStrategyParamL1.getName(), agStrategyParamL1.getValue());
			}
		}
		/*
		 * List<AgStrategyParamL1> list1 = ag1Service.selectById(strategyId); for
		 * (AgStrategyParamL1 a1 : list1) { m1.put("ParamName", a1.getName());
		 * m1.put("ParamValue", a1.getValue()); m.put(a1.getAccountID(), m1); } if
		 * (list1.isEmpty()) { Map<Integer, Map<String, String>> map =
		 * ag2Service.selectByStrategyId(strategyId); if (map.isEmpty()) { Map<Integer,
		 * Map<String, String>> map2 = ag2Service.selectById(strategyId); if
		 * (map2.isEmpty()) { Map<Integer, Map<String, String>> map3 =
		 * agService.selectById(strategyId); return jsonResponse(map3); } return
		 * jsonResponse(map2); } return jsonResponse(map); }
		 */
		return jsonResponse(m);
	}

	@GET
	@Path("/findStrategy/{strategyId}")
	@Produces(JSON_UTF8)
	@Consumes(JSON_UTF8)
	public ResponseTemplate<List<AgAccount>> findStrategy(@PathParam("strategyId") int strategyId) {
		List<AgAccount> list = accountService.selectByStrategy(strategyId);
		return ResponseTemplate.ok(list);
	}

	/*
	 * @GET
	 * 
	 * @Path("/actualCsvFile/{userId}/{strategyId}")
	 * 
	 * @Produces(JSON_UTF8) public Response RptActualCsvFile(@PathParam("userId")
	 * int userId,@PathParam("strategyId") int strategyId,@PathParam("stime") String
	 * stime,@PathParam("endtime") String endtime) { SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyy-MM-dd");//yyyy-MM-dd HH:mm:ss Date date; try { date =
	 * sdf.parse("2018-09-10"); List<RptActual>
	 * list=rptService.selectByCustomer(userId, strategyId, date); List<Map<String,
	 * String>> exportData = new ArrayList<Map<String, String>>(); for(RptActual
	 * ra:list) { //log.info(""+ra); Map<String, String> row1 = new
	 * LinkedHashMap<String, String>(); row1.put("1",ra.getAsOfDate().toString());
	 * row1.put("2",String.valueOf(ra.getCustomerID()));
	 * row1.put("3",ra.getCustomerName());
	 * row1.put("4",String.valueOf(ra.getClientID()));
	 * row1.put("5",ra.getClientName());
	 * row1.put("6",String.valueOf(ra.getStrategyID()));
	 * row1.put("7",ra.getStrategyName());
	 * row1.put("8",String.valueOf(ra.getAccountID()));
	 * row1.put("9",ra.getQuoteID()); row1.put("10",ra.getClOrdID());
	 * row1.put("11",ra.getOrderID());
	 * row1.put("12",String.valueOf(ra.getSymbol()));
	 * row1.put("13",ra.getSecurityType()); row1.put("14",ra.getSecurityExchange());
	 * row1.put("15",ra.getSide()); //row1.put("16",ra.getOrderTime().toString());
	 * row1.put("17",String.valueOf(ra.getOrderQty()));
	 * row1.put("18",ra.getOrdType()); row1.put("19",String.valueOf(ra.getPrice()));
	 * row1.put("20",String.valueOf(ra.getCumQty()));
	 * row1.put("21",String.valueOf(ra.getCanceledQty()));
	 * row1.put("22",String.valueOf(ra.getAvgPx()));
	 * row1.put("23",String.valueOf(ra.getFee())); exportData.add(row1); }
	 * LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
	 * //设置列名 map.put("1", "AsOfDate"); map.put("2", "CustomerID"); map.put("3",
	 * "CustomerName"); map.put("4", "ClientID"); map.put("5", "ClientName");
	 * map.put("6", "StrategyID"); map.put("7", "StrategyName"); map.put("8",
	 * "AccountID"); map.put("9", "QuoteID"); map.put("10", "ClOrdID");
	 * map.put("11", "OrderID"); map.put("12", "Symbol"); map.put("13",
	 * "SecurityType"); map.put("14", "SecurityExchange"); map.put("15", "Side");
	 * //map.put("16", "OrderTime"); map.put("17", "OrderQty"); map.put("18",
	 * "OrdType"); map.put("19", "Price"); map.put("20", "CumQty"); map.put("21",
	 * "CanceledQty"); map.put("22", "AvgPx"); map.put("23", "Fee"); File directory
	 * = new File("");//设定为当前文件夹 log.info(directory.getCanonicalPath());//获取标准的路径
	 * log.info(directory.getAbsolutePath());//获取绝对路径 String csvFilePath
	 * ="E://csvFile"; //文件名=生产的文件名称+时间戳 String fileName = "文件导出"; File file =
	 * CSVUtil.createCSVFile(exportData, map, csvFilePath, fileName); String
	 * fileName2 = file.getName(); log.info("文件名称：" + fileName2); } catch (Exception
	 * e) { log.error("", e); } return jsonResponse(ResponseJson.success); }
	 */

	/**
	 * 母单结算表
	 */
	@GET
	@Path("/nominalCsvFile/{userId}/{strategyId}")
	@Produces(JSON_UTF8)
	public Response RptNominalCsvFile(@PathParam("userId") int userId, @PathParam("strategyId") int strategyId,
			@PathParam("stime") Date stime, @PathParam("endtime") Date endtime) {
		try {
			List<RptNominal> list = nominalService.selectByCustomer(userId, strategyId, stime, endtime);
			List<Map<String, String>> exportData = new ArrayList<Map<String, String>>();
			for (RptNominal ra : list) {
				Map<String, String> row1 = new LinkedHashMap<String, String>();
				row1.put("1", ra.getAsOfDate().toString());
				row1.put("2", String.valueOf(ra.getCustomerId()));
				row1.put("3", ra.getCustomerName());
				row1.put("4", String.valueOf(ra.getClientId()));
				row1.put("5", ra.getClientName());
				row1.put("6", String.valueOf(ra.getStrategyId()));
				row1.put("7", ra.getStrategyName());
				row1.put("8", String.valueOf(ra.getAccountId()));
				row1.put("9", ra.getQuoteId());
				row1.put("10", String.valueOf(ra.getSymbol()));
				row1.put("11", ra.getSecurityType());
				row1.put("12", ra.getSecurityExchange());
				row1.put("13", ra.getStartTime().toString());
				row1.put("14", ra.getEndTime().toString());
				row1.put("15", ra.getDeliverTime().toString());
				row1.put("16", ra.getCancelTime().toString());
				row1.put("17", String.valueOf(ra.getTaskQty()));
				row1.put("18", String.valueOf(ra.getCancelQty()));
				row1.put("19", ra.getBenchmarkType());
				row1.put("20", String.valueOf(ra.getTWAP()));
				row1.put("21", String.valueOf(ra.getVWAP()));
				row1.put("22", String.valueOf(ra.getArrivalPrice()));
				row1.put("23", String.valueOf(ra.getClosePrice()));
				row1.put("24", String.valueOf(ra.getFilledQtyAgg()));
				row1.put("25", String.valueOf(ra.getDifQtyAgg()));
				row1.put("26", String.valueOf(ra.getFilledPriceAgg()));
				row1.put("27", String.valueOf(ra.getOrderCountAgg()));
				row1.put("28", String.valueOf(ra.getCanceledCountAgg()));
				row1.put("29", String.valueOf(ra.getFeeAgg()));
				row1.put("30", String.valueOf(ra.getMarketStatus()));
				exportData.add(row1);
			}
			LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
			map.put("1", "AsOfDate");
			map.put("2", "CustomerID");
			map.put("3", "CustomerName");
			map.put("4", "ClientID");
			map.put("5", "ClientName");
			map.put("6", "StrategyID");
			map.put("7", "StrategyName");
			map.put("8", "AccountID");
			map.put("9", "QuoteID");
			map.put("10", "Symbol");
			map.put("11", "SecurityType");
			map.put("12", "SecurityExchange");
			map.put("13", "StartTime");
			map.put("14", "EndTime");
			map.put("15", "DeliverTime");
			map.put("16", "CancelTime");
			map.put("17", "TaskQty");
			map.put("18", "CancelQty");
			map.put("19", "BenchmarkType");
			map.put("20", "TWAP");
			map.put("21", "VWAP");
			map.put("22", "ArrivalPrice");
			map.put("23", "ClosePrice");
			map.put("24", "FilledQtyAgg");
			map.put("25", "DifQtyAgg");
			map.put("26", "FilledPriceAgg");
			map.put("27", "OrderCountAgg");
			map.put("28", "CanceledCountAgg");
			map.put("29", "FeeAgg");
			map.put("30", "MarketStatus");
			String csvFilePath = "E://csvFile";
			// 文件名=生产的文件名称+时间戳
			String fileName = "文件导出";
			File file = CSVUtil.createCSVFile(exportData, map, csvFilePath, fileName);
			String fileName2 = file.getName();
			log.info("文件名称：" + fileName2);
		} catch (Exception e) {
			log.error("REST: /nominalCsvFile/{}/{} 出现异常，异常信息：{}", userId, strategyId, e);
		}
		return null;
	}

	/**
	 * 策略(子账户)结算表
	 */
	@GET
	@Path("/strategyCsvFile/{userId}/{strategyId}/{asOfDate}")
	@Produces(JSON_UTF8)
	public Response strategyCsvFile(@PathParam("userId") int userId, @PathParam("strategyId") int strategyId,
			@PathParam("stime") Date stime, @PathParam("endtime") Date endtime) {
		List<RptStrategy> list = strategyService.selectByCustomer(userId, strategyId, stime, endtime);
		List<Map<String, String>> exportData = new ArrayList<Map<String, String>>();
		for (RptStrategy ra : list) {
			Map<String, String> row1 = new LinkedHashMap<String, String>();
			row1.put("1", ra.getAsOfDate().toString());
			row1.put("2", String.valueOf(ra.getCustomerId()));
			row1.put("3", ra.getCustomerName());
			row1.put("4", String.valueOf(ra.getClientId()));
			row1.put("5", ra.getClientName());
			row1.put("6", String.valueOf(ra.getStrategyId()));
			row1.put("7", ra.getStrategyName());
			row1.put("8", String.valueOf(ra.getAccountId()));
			row1.put("9", String.valueOf(ra.getTaskMcap()));
			row1.put("10", String.valueOf(ra.getFilledMcap()));
			row1.put("11", String.valueOf(ra.getOverMcap()));
			row1.put("12", String.valueOf(ra.getUnderMcap()));
			row1.put("13", String.valueOf(ra.getCancelRatio()));
			row1.put("14", String.valueOf(ra.getPnLLiq()));
			row1.put("15", String.valueOf(ra.getPnLBPS()));
			row1.put("16", String.valueOf(ra.getPnLYuan()));
		}
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("1", "AsOfDate");
		map.put("2", "CustomerID");
		map.put("3", "CustomerName");
		map.put("4", "ClientID");
		map.put("5", "ClientName");
		map.put("6", "StrategyID");
		map.put("7", "StrategyName");
		map.put("8", "AccountID");
		map.put("9", "TaskMcap");
		map.put("10", "FilledMcap");
		map.put("11", "OverMcap");
		map.put("12", "UnderMcap");
		map.put("13", "CancelRatio");
		map.put("14", "PnLLiq");
		map.put("15", "PnLBPS");
		map.put("16", "PnLYuan");
		String csvFilePath = "E://csvFile";
		// 文件名=生产的文件名称+时间戳
		String fileName = "文件导出";
		File file = CSVUtil.createCSVFile(exportData, map, csvFilePath, fileName);
		String fileName2 = file.getName();
		log.info("文件名称：" + fileName2);
		return null;
	}

}
