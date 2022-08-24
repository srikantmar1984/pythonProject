class gpay_msg(Exception):
    def __init__(self,msg):
        self.msg = msg
def get_pan():
    pan = eval(input('Enter your PAN No'))
    len_pan = len(str(pan))
    if len_pan != 10:
        print('please enter correct pan number') 
        get_pan()
    else:
        print('Give me 2 minutes We will verifify and deposit the amount') 
def gpay():
    try:
        amt = eval(input('Enter the amount for send'))
        if amt< 50000:
            print('CODE FOR SENDING THE AMOUNT EXECUTED')
        elif amt< 60000:
            get_pan()
        else:
            raise gpay_msg('OVER LIMIT')
    except Exception as e:
        raise gpay_msg(e)