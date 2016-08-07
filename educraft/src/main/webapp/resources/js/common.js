Date.prototype.format = function(format) {
	if (!this.valueOf()) return " ";

    var weekName = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];
    var cal = this;

    return format.replace(/(yyyy|yy|MM|dd|E|hh|mm|ss|a\/p)/gi, function($1) {
        switch ($1) {
            case "yyyy": return cal.getFullYear();
            case "yy": return (cal.getFullYear() % 1000).zf(2);
            case "MM": return (cal.getMonth() + 1).zf(2);
            case "dd": return cal.getDate().zf(2);
            case "E": return weekName[cal.getDay()];
            case "HH": return cal.getHours().zf(2);
            case "hh": return ((h = d.getHours() % 12) ? h : 12).zf(2);
            case "mm": return cal.getMinutes().zf(2);
            case "ss": return cal.getSeconds().zf(2);
            case "a/p": return cal.getHours() < 12 ? "오전" : "오후";
            default: return $1;
        }
    });
};
	
String.prototype.string = function(len){var s = '', i = 0; while (i++ < len) { s += this; } return s;};
String.prototype.zf = function(len){return "0".string(len - this.length) + this;};
Number.prototype.zf = function(len){return this.toString().zf(len);};