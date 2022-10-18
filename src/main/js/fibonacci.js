
var original_fibonacci = {
    fibonacci : function(n) {
        if (n === 0) {
            return 0;
        } else if (n === 1) {
            return 1;
        } else {
            return this.fibonacci(n - 1) +
                this.fibonacci(n - 2);
        }
    }
};

var jaime_fibonacci = {
    fibonacci : function(n) {
        if (n <= 1) {
            return n;
        } else if (n === 2) {
            return 1;
        } else if (n === 3) {
            return 2;
        }
        let res = 3;
        if (n - 2 <= 3) {
            for (i = n; i > n - 3; i--) {
                res += i - 3;
            }
        } else {
            res = 2
            for (i = n - 1; i > n - 1 - 3; i--) {
                res += i - 3;
                if (i - 1 > 0) {
                    res += i - 1 - 3;
                }
            }
        }
        return res;
    }
};

var manuC_fibonacci = {
    fibonacci : function(n) {
        if(n<=1){
            return n;
        }
        let array = new Array(0,1);
        for(let i = 2 ; i <= n ; i++) {
            array[i] = array[i-1] + array[i-2];
        }
        return array[n]
    }
};

