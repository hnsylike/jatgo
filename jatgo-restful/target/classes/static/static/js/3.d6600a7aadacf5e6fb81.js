webpackJsonp([3],{FWmj:function(t,e,o){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var l=o("mtWM"),a=o.n(l),r=o("X2Oc"),n={inject:["reload"],name:"orderQuantity",data:function(){return{userID:"",tableData:[],censorDate:[],dateID:""}},methods:{timestampToTimes:function(t){var e=new Date(t);return e.getFullYear()+"-"+((e.getMonth()+1<10?"0"+(e.getMonth()+1):e.getMonth()+1)+"-")+(e.getDate()+" ")+(e.getHours()+":")+(e.getMinutes()+":")+e.getSeconds()},toggleSelection:function(t){var e=this;console.log(t),t?t.forEach(function(t){e.$refs.multipleTable.toggleRowSelection(t)}):this.$refs.multipleTable.clearSelection()},handleSelectionChange:function(t){console.log(t),this.censorDate=t,console.log(this.censorDate)},filterHandler:function(t,e,o){return e[o.property]===t},getData:function(){var t=this;this.userID=r.a.decipher("wsUserID"),console.log("11111111111111111111",domain.ordQueryOrder+this.userID),a.a.get(domain.ordQueryOrder+this.userID).then(function(e){if(console.log(e),"500"==e.data.httpCode)return r.a.altPrompt("获取数据失败，请重试"),!1;if("200"==e.data.httpCode){for(var o=0;o<e.data.responseEntity.length;o++)e.data.responseEntity[o].effectiveTime=t.timestampToTimes(e.data.responseEntity[o].effectiveTime),e.data.responseEntity[o].expireTime=t.timestampToTimes(e.data.responseEntity[o].expireTime),e.data.responseEntity[o].transactTime=t.timestampToTimes(e.data.responseEntity[o].transactTime);t.tableData=e.data.responseEntity}}).catch(function(t){console.log(t)}),console.log(this.tableData)},censorClick:function(){var t=this;console.log(this.censorDate,this.censorDate,domain.ordSendOrder);for(var e=0;e<this.censorDate.length;e++)this.dateID=this.censorDate[e].id,console.log(this.dateID),a.a.post(domain.ordSendOrder,{id:this.dateID}).then(function(e){return console.log(e),"200"==e.data.httpCode?(r.a.altPrompt("审核成功"),t.reload(),!1):"500"==e.data?(r.a.altPrompt("审核失败"),!1):void 0}).catch(function(t){console.log(t)})}},mounted:function(){console.log("el被新创建的$el替换，并挂载到实例上去之后调用本钩子"),this.getData()}},i={render:function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",[o("h2",[t._v("算法单审核页面")]),t._v(" "),o("div",{attrs:{id:"content-list"}},[o("div",[[o("el-table",{ref:"multipleTable",staticStyle:{width:"100%"},attrs:{border:"",data:t.tableData,"tooltip-effect":"dark"},on:{"selection-change":t.handleSelectionChange}},[o("el-table-column",{attrs:{fixed:"",type:"selection",width:"55"}}),t._v(" "),o("el-table-column",{attrs:{prop:"date",sortable:"","filter-method":t.filterHandler,label:"日期",width:"120"}}),t._v(" "),o("el-table-column",{attrs:{prop:"clientID",label:"账户编号",width:"120"}}),t._v(" "),o("el-table-column",{attrs:{prop:"accountID",label:"策略编号","show-overflow-tooltip":""}}),t._v(" "),o("el-table-column",{attrs:{prop:"afterAction",label:"结束后是否继续执行","show-overflow-tooltip":""}}),t._v(" "),o("el-table-column",{attrs:{prop:"clOrdID",label:"委托编号","show-overflow-tooltip":""}}),t._v(" "),o("el-table-column",{attrs:{prop:"effectiveTime",label:"订单生效时间","show-overflow-tooltip":""}}),t._v(" "),o("el-table-column",{attrs:{prop:"expireTime",label:"订单终止时间","show-overflow-tooltip":""}}),t._v(" "),o("el-table-column",{attrs:{prop:"limitAction",label:"涨停跌停","show-overflow-tooltip":""}}),t._v(" "),o("el-table-column",{attrs:{prop:"symbol",label:"证券代码","show-overflow-tooltip":""}}),t._v(" "),o("el-table-column",{attrs:{prop:"side",label:"买/卖","show-overflow-tooltip":""}}),t._v(" "),o("el-table-column",{attrs:{prop:"securityExchange",label:"交易所类型","show-overflow-tooltip":""}}),t._v(" "),o("el-table-column",{attrs:{prop:"ordType",label:"委托类型","show-overflow-tooltip":""}}),t._v(" "),o("el-table-column",{attrs:{prop:"securityType",label:"证券类型","show-overflow-tooltip":""}}),t._v(" "),o("el-table-column",{attrs:{prop:"orderQty",label:"委托股数","show-overflow-tooltip":""}}),t._v(" "),o("el-table-column",{attrs:{prop:"price",label:"委托价格","show-overflow-tooltip":""}}),t._v(" "),o("el-table-column",{attrs:{prop:"transactTime",label:"委托时间","show-overflow-tooltip":""}})],1),t._v(" "),o("div",{staticStyle:{"margin-top":"20px"}},[o("el-button",{attrs:{type:"primary"},on:{click:t.censorClick}},[t._v("确认审核")]),t._v(" "),o("el-button",{attrs:{type:"info"},on:{click:function(e){t.toggleSelection()}}},[t._v("取消选择")])],1)]],2)])])},staticRenderFns:[]};var s=o("VU/8")(n,i,!1,function(t){o("wXdz")},null,null);e.default=s.exports},wXdz:function(t,e){}});
//# sourceMappingURL=3.d6600a7aadacf5e6fb81.js.map