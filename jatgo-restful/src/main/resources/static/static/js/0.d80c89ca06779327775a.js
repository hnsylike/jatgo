webpackJsonp([0],{"/9vT":function(t,e){},"1Bl0":function(t,e,r){t.exports=r.p+"static/img/5.a052ab4.jpg"},PDE6:function(t,e,r){t.exports=r.p+"static/img/6.f67a8eb.jpg"},QrVH:function(t,e,r){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var n=r("Xxa5"),o=r.n(n),i=r("pFYg"),a=r.n(i),s=r("exGp"),u=r.n(s),c=r("mtWM"),l=r.n(c),p=r("X2Oc"),h=r("7QTg"),f={name:"login",components:{swiper:h.swiper,swiperSlide:h.swiperSlide},data:function(){var t=this;return{username:"",psw:"",phoneNum:"",cod:"",disabled:"",swiperOption:{notNextTick:!0,slidesPerView:"auto",autoplay:!0,disableOnInteraction:!1,effect:"flip",centeredSlides:!0,spaceBetween:0,onSlideChangeEnd:function(e){t.page=e.realIndex+1,t.index=e.realIndex}}}},computed:{swiper:function(){return this.$refs.mySwiper.swiper}},directives:{focus:{inserted:function(t){t.focus()}}},methods:{getAuthbaseUrl:function(){console.log(domain.authbaseUrl),l.a.get(domain.authbaseUrl).then(function(t){console.log(t)}).catch(function(t){console.log(t),window.open(domain.authbaseUrl)})},getCod:function(){var t=u()(o.a.mark(function t(e){var r;return o.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:if(r=e.target,console.log("点击获取验证码",this.phoneNum,r,void 0===r?"undefined":a()(r),domain.logGetCod+this.phoneNum),!p.a.isNull(this.phoneNum)){t.next=5;break}return p.a.altPrompt("手机号不能为空"),t.abrupt("return",!1);case 5:return this.disabled="disabled",p.a.daojishi("60"),t.next=9,l.a.get(domain.logGetCod+this.phoneNum).then(function(t){console.log(t),"200"==t.data.httpCode?p.a.altPrompt("验证码已发送"):p.a.altPrompt("发送频率过快，请稍后重试")}).catch(function(t){console.log(t)});case 9:case"end":return t.stop()}},t,this)}));return function(e){return t.apply(this,arguments)}}(),goLogin:function(){var t=u()(o.a.mark(function t(){var e,r;return o.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:if(e=/^((13[0-9])|(14[5|7])|(17[5|7|6])|(15([0-3]|[5-9]))|(18[0,5-9]))\d{8}$/,r=/^[0-9]{6}$/,console.log(this.username,this.psw,this.phoneNum,this.cod),!p.a.isNull(this.username)){t.next=8;break}return p.a.altPrompt("用户名不能为空"),t.abrupt("return",!1);case 8:if(!p.a.isNull(this.psw)){t.next=13;break}return p.a.altPrompt("密码不能为空"),t.abrupt("return",!1);case 13:if(!p.a.isNull(this.phoneNum)){t.next=18;break}return p.a.altPrompt("手机号不能为空"),t.abrupt("return",!1);case 18:if(e.test(this.phoneNum)){t.next=23;break}return p.a.altPrompt("手机号格式错误"),t.abrupt("return",!1);case 23:if(!p.a.isNull(this.cod)){t.next=28;break}return p.a.altPrompt("验证码不能为空"),t.abrupt("return",!1);case 28:if(r.test(this.cod)){t.next=31;break}return p.a.altPrompt("验证码格式"),t.abrupt("return",!1);case 31:return console.log(domain.logLogin),t.next=34,l.a.post(domain.logLogin,{username:this.username,password:this.psw,phone:this.phoneNum,smsCode:this.cod}).then(function(t){if(console.log(t),"500"==t.data.httpCode)return p.a.altPrompt(t.data.errorMsg),!1;if("200"==t.data.httpCode){var e=t.data.responseEntity;p.a.encrypt("token",e.token),p.a.encrypt("wsUserID",e.wsUser.userid),p.a.encrypt("wsCustomerID",e.wsUser.customerId),p.a.encrypt("wsUserName",e.wsUser.username),p.a.encrypt("wsUserRole",e.wsUser.role),this.$message({type:"success",message:"登陆成功"}),"trader"==e.wsUser.role?this.$router.push({name:"tabsEntrust",params:{token:e.token}}):"admin"==e.wsUser.role&&this.$router.push({name:"tabsSee",params:{token:e.token}})}}.bind(this)).catch(function(t){console.log(t)});case 34:case"end":return t.stop()}},t,this)}));return function(){return t.apply(this,arguments)}}(),goRegister:function(){console.log("注册"),this.$router.push({name:"register"})}},beforeCreate:function(){console.log("1.实例创建之前执行本钩子")},created:function(){console.log("2.实例已经创建完成调用本钩子")},beforeMount:function(){console.log("3.实例挂载之前执行本钩子")},mounted:function(){console.log("4.el被新创建的$el替换，并挂载到实例上去之后调用本钩子"),this.getAuthbaseUrl(),this.swiper.slideTo(0,0,!1)},beforeUpdate:function(){console.log("5.数据更新时调用该钩子，发生在虚拟DOM重新渲染和打补丁之前")},updated:function(){console.log("6.数据更新后调用该钩子，该钩子被调用时，组件DOM已经更新")},beforeDestroy:function(){console.log("7.实例销毁之前调用本钩子")},destroyed:function(){console.log("8.实例销毁后执行本钩子")}},d={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("div",{attrs:{id:"content"}},[n("form",{attrs:{id:"userfom",name:"userfom"}},[n("h1",[t._v("ATGO股票交易系统")]),t._v(" "),n("div",[t._v("用户名："),n("input",{directives:[{name:"focus",rawName:"v-focus"},{name:"model",rawName:"v-model",value:t.username,expression:"username"}],attrs:{type:"text",id:"username",name:"username",placeholder:"请输入用户名"},domProps:{value:t.username},on:{input:function(e){e.target.composing||(t.username=e.target.value)}}})]),t._v(" "),n("div",[n("span",{staticClass:"sp"},[t._v("密码")]),t._v("："),n("input",{directives:[{name:"model",rawName:"v-model",value:t.psw,expression:"psw"}],attrs:{type:"password",name:"password",id:"password",placeholder:"请输入密码"},domProps:{value:t.psw},on:{input:function(e){e.target.composing||(t.psw=e.target.value)}}})]),t._v(" "),n("div",[t._v("手机号："),n("input",{directives:[{name:"model",rawName:"v-model",value:t.phoneNum,expression:"phoneNum"}],attrs:{type:"text",maxlength:"11",id:"userPhone",placeholder:"请输入手机号"},domProps:{value:t.phoneNum},on:{input:function(e){e.target.composing||(t.phoneNum=e.target.value)}}})]),t._v(" "),n("div",{staticClass:"cod"},[t._v("\n          验证码：\n          "),n("input",{directives:[{name:"model",rawName:"v-model",value:t.cod,expression:"cod"}],attrs:{type:"text",maxlength:"6",id:"userCod",placeholder:"请输入验证码"},domProps:{value:t.cod},on:{input:function(e){e.target.composing||(t.cod=e.target.value)}}}),n("span",{class:t.disabled,attrs:{id:"getCod"},on:{click:t.getCod}},[t._v("获取验证码")])]),t._v(" "),n("button",{attrs:{id:"logBut",type:"button"},on:{click:t.goLogin}},[t._v("登录")]),t._v(" "),n("button",{attrs:{id:"register",type:"button"},on:{click:t.goRegister}},[t._v("注册")])])]),t._v(" "),n("swiper",{ref:"mySwiper",attrs:{options:t.swiperOption}},[n("swiper-slide",[n("img",{attrs:{src:r("n07r"),alt:"",srcset:""}})]),t._v(" "),n("swiper-slide",[n("img",{attrs:{src:r("1Bl0"),alt:"",srcset:""}})]),t._v(" "),n("swiper-slide",[n("img",{attrs:{src:r("PDE6"),alt:"",srcset:""}})])],1)],1)},staticRenderFns:[]};var m=r("VU/8")(f,d,!1,function(t){r("/9vT")},null,null);e.default=m.exports},SldL:function(t,e){!function(e){"use strict";var r,n=Object.prototype,o=n.hasOwnProperty,i="function"==typeof Symbol?Symbol:{},a=i.iterator||"@@iterator",s=i.asyncIterator||"@@asyncIterator",u=i.toStringTag||"@@toStringTag",c="object"==typeof t,l=e.regeneratorRuntime;if(l)c&&(t.exports=l);else{(l=e.regeneratorRuntime=c?t.exports:{}).wrap=x;var p="suspendedStart",h="suspendedYield",f="executing",d="completed",m={},g={};g[a]=function(){return this};var v=Object.getPrototypeOf,y=v&&v(v(C([])));y&&y!==n&&o.call(y,a)&&(g=y);var w=N.prototype=_.prototype=Object.create(g);L.prototype=w.constructor=N,N.constructor=L,N[u]=L.displayName="GeneratorFunction",l.isGeneratorFunction=function(t){var e="function"==typeof t&&t.constructor;return!!e&&(e===L||"GeneratorFunction"===(e.displayName||e.name))},l.mark=function(t){return Object.setPrototypeOf?Object.setPrototypeOf(t,N):(t.__proto__=N,u in t||(t[u]="GeneratorFunction")),t.prototype=Object.create(w),t},l.awrap=function(t){return{__await:t}},k(E.prototype),E.prototype[s]=function(){return this},l.AsyncIterator=E,l.async=function(t,e,r,n){var o=new E(x(t,e,r,n));return l.isGeneratorFunction(e)?o:o.next().then(function(t){return t.done?t.value:o.next()})},k(w),w[u]="Generator",w[a]=function(){return this},w.toString=function(){return"[object Generator]"},l.keys=function(t){var e=[];for(var r in t)e.push(r);return e.reverse(),function r(){for(;e.length;){var n=e.pop();if(n in t)return r.value=n,r.done=!1,r}return r.done=!0,r}},l.values=C,U.prototype={constructor:U,reset:function(t){if(this.prev=0,this.next=0,this.sent=this._sent=r,this.done=!1,this.delegate=null,this.method="next",this.arg=r,this.tryEntries.forEach(j),!t)for(var e in this)"t"===e.charAt(0)&&o.call(this,e)&&!isNaN(+e.slice(1))&&(this[e]=r)},stop:function(){this.done=!0;var t=this.tryEntries[0].completion;if("throw"===t.type)throw t.arg;return this.rval},dispatchException:function(t){if(this.done)throw t;var e=this;function n(n,o){return s.type="throw",s.arg=t,e.next=n,o&&(e.method="next",e.arg=r),!!o}for(var i=this.tryEntries.length-1;i>=0;--i){var a=this.tryEntries[i],s=a.completion;if("root"===a.tryLoc)return n("end");if(a.tryLoc<=this.prev){var u=o.call(a,"catchLoc"),c=o.call(a,"finallyLoc");if(u&&c){if(this.prev<a.catchLoc)return n(a.catchLoc,!0);if(this.prev<a.finallyLoc)return n(a.finallyLoc)}else if(u){if(this.prev<a.catchLoc)return n(a.catchLoc,!0)}else{if(!c)throw new Error("try statement without catch or finally");if(this.prev<a.finallyLoc)return n(a.finallyLoc)}}}},abrupt:function(t,e){for(var r=this.tryEntries.length-1;r>=0;--r){var n=this.tryEntries[r];if(n.tryLoc<=this.prev&&o.call(n,"finallyLoc")&&this.prev<n.finallyLoc){var i=n;break}}i&&("break"===t||"continue"===t)&&i.tryLoc<=e&&e<=i.finallyLoc&&(i=null);var a=i?i.completion:{};return a.type=t,a.arg=e,i?(this.method="next",this.next=i.finallyLoc,m):this.complete(a)},complete:function(t,e){if("throw"===t.type)throw t.arg;return"break"===t.type||"continue"===t.type?this.next=t.arg:"return"===t.type?(this.rval=this.arg=t.arg,this.method="return",this.next="end"):"normal"===t.type&&e&&(this.next=e),m},finish:function(t){for(var e=this.tryEntries.length-1;e>=0;--e){var r=this.tryEntries[e];if(r.finallyLoc===t)return this.complete(r.completion,r.afterLoc),j(r),m}},catch:function(t){for(var e=this.tryEntries.length-1;e>=0;--e){var r=this.tryEntries[e];if(r.tryLoc===t){var n=r.completion;if("throw"===n.type){var o=n.arg;j(r)}return o}}throw new Error("illegal catch attempt")},delegateYield:function(t,e,n){return this.delegate={iterator:C(t),resultName:e,nextLoc:n},"next"===this.method&&(this.arg=r),m}}}function x(t,e,r,n){var o=e&&e.prototype instanceof _?e:_,i=Object.create(o.prototype),a=new U(n||[]);return i._invoke=function(t,e,r){var n=p;return function(o,i){if(n===f)throw new Error("Generator is already running");if(n===d){if("throw"===o)throw i;return S()}for(r.method=o,r.arg=i;;){var a=r.delegate;if(a){var s=P(a,r);if(s){if(s===m)continue;return s}}if("next"===r.method)r.sent=r._sent=r.arg;else if("throw"===r.method){if(n===p)throw n=d,r.arg;r.dispatchException(r.arg)}else"return"===r.method&&r.abrupt("return",r.arg);n=f;var u=b(t,e,r);if("normal"===u.type){if(n=r.done?d:h,u.arg===m)continue;return{value:u.arg,done:r.done}}"throw"===u.type&&(n=d,r.method="throw",r.arg=u.arg)}}}(t,r,a),i}function b(t,e,r){try{return{type:"normal",arg:t.call(e,r)}}catch(t){return{type:"throw",arg:t}}}function _(){}function L(){}function N(){}function k(t){["next","throw","return"].forEach(function(e){t[e]=function(t){return this._invoke(e,t)}})}function E(t){var e;this._invoke=function(r,n){function i(){return new Promise(function(e,i){!function e(r,n,i,a){var s=b(t[r],t,n);if("throw"!==s.type){var u=s.arg,c=u.value;return c&&"object"==typeof c&&o.call(c,"__await")?Promise.resolve(c.__await).then(function(t){e("next",t,i,a)},function(t){e("throw",t,i,a)}):Promise.resolve(c).then(function(t){u.value=t,i(u)},a)}a(s.arg)}(r,n,e,i)})}return e=e?e.then(i,i):i()}}function P(t,e){var n=t.iterator[e.method];if(n===r){if(e.delegate=null,"throw"===e.method){if(t.iterator.return&&(e.method="return",e.arg=r,P(t,e),"throw"===e.method))return m;e.method="throw",e.arg=new TypeError("The iterator does not provide a 'throw' method")}return m}var o=b(n,t.iterator,e.arg);if("throw"===o.type)return e.method="throw",e.arg=o.arg,e.delegate=null,m;var i=o.arg;return i?i.done?(e[t.resultName]=i.value,e.next=t.nextLoc,"return"!==e.method&&(e.method="next",e.arg=r),e.delegate=null,m):i:(e.method="throw",e.arg=new TypeError("iterator result is not an object"),e.delegate=null,m)}function O(t){var e={tryLoc:t[0]};1 in t&&(e.catchLoc=t[1]),2 in t&&(e.finallyLoc=t[2],e.afterLoc=t[3]),this.tryEntries.push(e)}function j(t){var e=t.completion||{};e.type="normal",delete e.arg,t.completion=e}function U(t){this.tryEntries=[{tryLoc:"root"}],t.forEach(O,this),this.reset(!0)}function C(t){if(t){var e=t[a];if(e)return e.call(t);if("function"==typeof t.next)return t;if(!isNaN(t.length)){var n=-1,i=function e(){for(;++n<t.length;)if(o.call(t,n))return e.value=t[n],e.done=!1,e;return e.value=r,e.done=!0,e};return i.next=i}}return{next:S}}function S(){return{value:r,done:!0}}}(function(){return this}()||Function("return this")())},Xxa5:function(t,e,r){t.exports=r("jyFz")},exGp:function(t,e,r){"use strict";e.__esModule=!0;var n,o=r("//Fk"),i=(n=o)&&n.__esModule?n:{default:n};e.default=function(t){return function(){var e=t.apply(this,arguments);return new i.default(function(t,r){return function n(o,a){try{var s=e[o](a),u=s.value}catch(t){return void r(t)}if(!s.done)return i.default.resolve(u).then(function(t){n("next",t)},function(t){n("throw",t)});t(u)}("next")})}}},jyFz:function(t,e,r){var n=function(){return this}()||Function("return this")(),o=n.regeneratorRuntime&&Object.getOwnPropertyNames(n).indexOf("regeneratorRuntime")>=0,i=o&&n.regeneratorRuntime;if(n.regeneratorRuntime=void 0,t.exports=r("SldL"),o)n.regeneratorRuntime=i;else try{delete n.regeneratorRuntime}catch(t){n.regeneratorRuntime=void 0}},n07r:function(t,e,r){t.exports=r.p+"static/img/4.890eae0.jpg"}});
//# sourceMappingURL=0.d80c89ca06779327775a.js.map