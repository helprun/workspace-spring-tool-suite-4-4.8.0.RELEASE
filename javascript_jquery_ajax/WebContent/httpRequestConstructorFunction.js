/*
	생성자 함수
 */
function AjaxRequest(url,params,callback,method){
	this.xhr=this.getXMLHttpRequest();
	this.url=url;
	this.params=params;
	this.callback=callback;
	this.method=method;
	//this.sendRequest();
}
AjaxRequest.prototype={
		'getXMLHttpRequest':function(){
			if(window.XMLHttpRequest){
				return new XMLHttpRequest();
			}else{
				return null;
			}
		},
		'sendRequest':function(){
			//this.xhr = this.getXMLHttpRequest();
			var httpMethod = this.method ? this.method : 'GET';
			if (httpMethod != 'GET' && httpMethod != 'POST') {
				httpMethod = 'GET';
			}
			var httpParams = (this.params == null || this.params == '') ? null : this.params;
			var httpUrl = this.url;
			if (httpMethod == 'GET' && httpParams != null) {
				httpUrl = httpUrl + "?" + httpParams;
			}
			var ajaxRequest = this;
			//this.xhr.onreadystatechange = this.callback;
			this.xhr.onreadystatechange = function() {
				ajaxRequest.callback(this);
			}
			
			this.xhr.open(httpMethod, httpUrl, true);
			this.xhr.setRequestHeader(
				'Content-Type', 'application/x-www-form-urlencoded');
			this.xhr.send(httpMethod == 'POST' ? httpParams : null);
		}
};

