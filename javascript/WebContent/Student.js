/**
 * 
 */
	var com = {}; //new Object();
	com.itwill = {}; //new Object();
	com.itwill.Student = function(id, name, kor, eng, math){
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.tot = 0;
		this.avg = 0.0;
	};
		
	//Student객체의 공용(instance) 메쏘드(prototype에 생성)
	/*
	com.itwill.Student.prototype.calculateTot = function() {
		this.tot = this.kor + this.math + this.eng;
	}
	
	com.itwill.Student.prototype.calculateAvg = function() {
		this.avg = this.tot / 3.0;
	}
	
	com.itwill.Student.prototype.toString= function() {
		return '[' + this.id + ']' + this.name + "," + this.kor + ","
				+ this.eng + "," + this.math + "," + this.tot + ","
				+ this.avg;
	}
	[] --> JSON array
	{} --> JSON Object
	*/
	
	/************ prototype[JSON] *************/
	com.itwill.Student.prototype = {
			'calculateTot': function() {
				this.tot = this.kor + this.math + this.eng;
			},
			
			'calculateAvg' : function() {
				this.avg = this.tot / 3.0;
			},
			
			'toString': function() {
				return '[' + this.id + ']' + this.name + "," + this.kor + ","
						+ this.eng + "," + this.math + "," + this.tot + ","
						+ this.avg;
			}
	};