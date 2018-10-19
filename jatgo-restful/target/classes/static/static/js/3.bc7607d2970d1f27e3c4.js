webpackJsonp([3],{JGCK:function(e,t,o){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var l=o("mtWM"),a=o.n(l),r=o("X2Oc"),i={inject:["reload"],name:"orderQuantity",data:function(){return{userID:"",tableData:[],censorDate:[],dateID:""}},methods:{timestampToTimes:function(e){var t=new Date(e);return t.getFullYear()+"-"+((t.getMonth()+1<10?"0"+(t.getMonth()+1):t.getMonth()+1)+"-")+(t.getDate()+" ")+(t.getHours()+":")+(t.getMinutes()+":")+t.getSeconds()},toggleSelection:function(e){var t=this;console.log(e),e?e.forEach(function(e){t.$refs.multipleTable.toggleRowSelection(e)}):this.$refs.multipleTable.clearSelection()},handleSelectionChange:function(e){console.log(e),this.censorDate=e,console.log(this.censorDate)},filterHandler:function(e,t,o){return t[o.property]===e},getData:function(){var e=this;this.userID=r.a.decipher("wsUserID"),console.log("11111111111111111111",domain.ordQueryOrder+"/"+this.userID),a.a.get(domain.ordQueryOrder+"/"+this.userID).then(function(t){if(console.log(t),"500"==t.data.httpCode)return r.a.altPrompt("获取数据失败，请重试"),!1;if("200"==t.data.httpCode)for(var o=0;o<t.data.length;o++)t.data[o].effectiveTime=e.timestampToTimes(t.data[o].effectiveTime),t.data[o].expireTime=e.timestampToTimes(t.data[o].expireTime),t.data[o].transactTime=e.timestampToTimes(t.data[o].transactTime),e.tableData.push(t.data[o])}).catch(function(e){console.log(e)}),console.log(this.tableData)},censorClick:function(){var e=this;console.log(this.censorDate,this.censorDate,domain.ordSendOrder);for(var t=0;t<this.censorDate.length;t++)this.dateID=this.censorDate[t].id,console.log(this.dateID),a.a.post(domain.ordSendOrder,{id:this.dateID}).then(function(t){return console.log(t),"200"==t.data.httpCode?(r.a.altPrompt("审核成功"),e.reload(),!1):"500"==t.data?(r.a.altPrompt("审核失败"),!1):void 0}).catch(function(e){console.log(e)})}},mounted:function(){console.log("el被新创建的$el替换，并挂载到实例上去之后调用本钩子"),this.getData()}},n={render:function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",[o("h2",[e._v("订单审核页面")]),e._v(" "),o("div",{attrs:{id:"content-list"}},[o("div",[[o("el-table",{ref:"multipleTable",staticStyle:{width:"100%"},attrs:{border:"",data:e.tableData,"tooltip-effect":"dark"},on:{"selection-change":e.handleSelectionChange}},[o("el-table-column",{attrs:{fixed:"",type:"selection",width:"55"}}),e._v(" "),o("el-table-column",{attrs:{prop:"date",sortable:"","filter-method":e.filterHandler,label:"日期",width:"120"}}),e._v(" "),o("el-table-column",{attrs:{prop:"clientID",label:"账户编号",width:"120"}}),e._v(" "),o("el-table-column",{attrs:{prop:"accountID",label:"策略编号","show-overflow-tooltip":""}}),e._v(" "),o("el-table-column",{attrs:{prop:"afterAction",label:"结束后是否继续执行","show-overflow-tooltip":""}}),e._v(" "),o("el-table-column",{attrs:{prop:"clOrdID",label:"委托编号","show-overflow-tooltip":""}}),e._v(" "),o("el-table-column",{attrs:{prop:"effectiveTime",label:"订单生效时间","show-overflow-tooltip":""}}),e._v(" "),o("el-table-column",{attrs:{prop:"expireTime",label:"订单终止时间","show-overflow-tooltip":""}}),e._v(" "),o("el-table-column",{attrs:{prop:"limitAction",label:"涨停跌停","show-overflow-tooltip":""}}),e._v(" "),o("el-table-column",{attrs:{prop:"symbol",label:"证券代码","show-overflow-tooltip":""}}),e._v(" "),o("el-table-column",{attrs:{prop:"side",label:"买/卖","show-overflow-tooltip":""}}),e._v(" "),o("el-table-column",{attrs:{prop:"securityExchange",label:"交易所类型","show-overflow-tooltip":""}}),e._v(" "),o("el-table-column",{attrs:{prop:"ordType",label:"委托类型","show-overflow-tooltip":""}}),e._v(" "),o("el-table-column",{attrs:{prop:"securityType",label:"证券类型","show-overflow-tooltip":""}}),e._v(" "),o("el-table-column",{attrs:{prop:"orderQty",label:"委托股数","show-overflow-tooltip":""}}),e._v(" "),o("el-table-column",{attrs:{prop:"price",label:"委托价格","show-overflow-tooltip":""}}),e._v(" "),o("el-table-column",{attrs:{prop:"transactTime",label:"委托时间","show-overflow-tooltip":""}})],1),e._v(" "),o("div",{staticStyle:{"margin-top":"20px"}},[o("el-button",{attrs:{type:"primary"},on:{click:e.censorClick}},[e._v("确认审核")]),e._v(" "),o("el-button",{attrs:{type:"info"},on:{click:function(t){e.toggleSelection()}}},[e._v("取消选择")])],1)]],2)])])},staticRenderFns:[]};var c={inject:["reload"],name:"commonRevocation",data:function(){return{comRevoData:[],choicecomRevoData:[],comRevoClientID:""}},methods:{getcomRevoDatas:function(){console.log("获取普通单审核数据"),this.comRevoData=[{date:"2018-09-11",clientID:"001",accountID:"001",clOrdID:"001",effectiveTime:"2011-11-11",expireTime:"2011-11-11",symbol:"001",side:"买",securityExchange:"001",ordType:"001",securityType:"001",orderQty:"001",price:"001",transactTime:"2011-11-11"},{date:"2018-08-15",clientID:"002",accountID:"001",clOrdID:"001",effectiveTime:"2011-11-11",expireTime:"2011-11-11",symbol:"001",side:"买",securityExchange:"001",ordType:"001",securityType:"001",orderQty:"001",price:"001",transactTime:"2011-11-11"},{date:"2018-10-10",clientID:"003",accountID:"001",clOrdID:"001",effectiveTime:"2011-11-11",expireTime:"2011-11-11",symbol:"001",side:"买",securityExchange:"001",ordType:"001",securityType:"001",orderQty:"001",price:"001",transactTime:"2011-11-11"},{date:"2018-07-07",clientID:"004",accountID:"001",clOrdID:"001",effectiveTime:"2011-11-11",expireTime:"2011-11-11",symbol:"001",side:"买",securityExchange:"001",ordType:"001",securityType:"001",orderQty:"001",price:"001",transactTime:"2011-11-11"},{date:"2018-12-12",clientID:"005",accountID:"001",clOrdID:"001",effectiveTime:"2011-11-11",expireTime:"2011-11-11",symbol:"001",side:"买",securityExchange:"001",ordType:"001",securityType:"001",orderQty:"001",price:"001",transactTime:"2011-11-11"}]},handleSelChangecomRevoData:function(e){console.log(e),this.choicecomRevoData=e,console.log(this.choicecomRevoData)},surecomRevoClick:function(){console.log("确认审核",this.choicecomRevoData);for(var e=0;e<this.choicecomRevoData.length;e++)this.comRevoClientID=this.choicecomRevoData[e].clientID,console.log(this.comRevoClientID),this.reload()},toggleSeleccomRevo:function(e){var t=this;console.log(e),e?e.forEach(function(e){t.$refs.multipleTable.toggleRowSelection(e)}):this.$refs.multipleTable.clearSelection()},filterHandlercomRevoData:function(e,t,o){return t[o.property]===e}},mounted:function(){this.getcomRevoDatas()}},s={render:function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",[o("h2",[e._v("普通单审核")]),e._v(" "),o("div",{attrs:{id:"comRevo"}},[o("div",[[o("el-table",{ref:"multipleTable",staticStyle:{width:"100%"},attrs:{border:"",data:e.comRevoData,"tooltip-effect":"dark"},on:{"selection-change":e.handleSelChangecomRevoData}},[o("el-table-column",{attrs:{fixed:"",type:"selection",width:"55"}}),e._v(" "),o("el-table-column",{attrs:{prop:"date",sortable:"","filter-method":e.filterHandlercomRevoData,label:"测试数据、日期",width:"120"}}),e._v(" "),o("el-table-column",{attrs:{prop:"clientID",label:"账户编号",width:"120"}}),e._v(" "),o("el-table-column",{attrs:{prop:"accountID",label:"策略编号","show-overflow-tooltip":""}}),e._v(" "),o("el-table-column",{attrs:{prop:"clOrdID",label:"委托编号","show-overflow-tooltip":""}}),e._v(" "),o("el-table-column",{attrs:{prop:"effectiveTime",label:"订单生效时间","show-overflow-tooltip":""}}),e._v(" "),o("el-table-column",{attrs:{prop:"expireTime",label:"订单终止时间","show-overflow-tooltip":""}}),e._v(" "),o("el-table-column",{attrs:{prop:"symbol",label:"证券代码","show-overflow-tooltip":""}}),e._v(" "),o("el-table-column",{attrs:{prop:"side",label:"买/卖","show-overflow-tooltip":""}}),e._v(" "),o("el-table-column",{attrs:{prop:"securityExchange",label:"交易所类型","show-overflow-tooltip":""}}),e._v(" "),o("el-table-column",{attrs:{prop:"ordType",label:"委托类型","show-overflow-tooltip":""}}),e._v(" "),o("el-table-column",{attrs:{prop:"securityType",label:"证券类型","show-overflow-tooltip":""}}),e._v(" "),o("el-table-column",{attrs:{prop:"orderQty",label:"委托股数","show-overflow-tooltip":""}}),e._v(" "),o("el-table-column",{attrs:{prop:"price",label:"委托价格","show-overflow-tooltip":""}}),e._v(" "),o("el-table-column",{attrs:{prop:"transactTime",label:"委托时间","show-overflow-tooltip":""}})],1),e._v(" "),o("div",{staticStyle:{"margin-top":"20px"}},[o("el-button",{attrs:{type:"primary"},on:{click:e.surecomRevoClick}},[e._v("确认审核")]),e._v(" "),o("el-button",{attrs:{type:"info"},on:{click:function(t){e.toggleSeleccomRevo()}}},[e._v("取消选择")])],1)]],2)])])},staticRenderFns:[]};var p={name:"tabsRevocation",data:function(){return{tabsParam:["算法单审核","普通单"],nowIndex:1}},components:{orderQuantity:o("VU/8")(i,n,!1,function(e){o("cN86")},null,null).exports,commonRevocation:o("VU/8")(c,s,!1,function(e){o("M3J4")},null,null).exports},methods:{toggleTabs:function(e){this.nowIndex=e},loginAginRev:function(){this.$router.push({name:"login",param:""})}}},v={render:function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{attrs:{id:"revoChoice"}},[o("ul",{staticClass:"tabs"},e._l(e.tabsParam,function(t,l){return o("li",{key:t,staticClass:"li-tab",class:{active:l!=e.nowIndex},on:{click:function(t){e.toggleTabs(l)}}},[e._v(e._s(t))])})),e._v(" "),o("span",{staticClass:"revoChoice",on:{click:e.loginAginRev}},[e._v("退出系统")]),e._v(" "),o("div",{directives:[{name:"show",rawName:"v-show",value:0===e.nowIndex,expression:"nowIndex===0"}],staticClass:"divTab"},[o("orderQuantity")],1),e._v(" "),o("div",{directives:[{name:"show",rawName:"v-show",value:1===e.nowIndex,expression:"nowIndex===1"}],staticClass:"divTab"},[o("commonRevocation")],1)])},staticRenderFns:[]};var d=o("VU/8")(p,v,!1,function(e){o("K3BG")},null,null);t.default=d.exports},K3BG:function(e,t){},M3J4:function(e,t){},cN86:function(e,t){}});
//# sourceMappingURL=3.bc7607d2970d1f27e3c4.js.map