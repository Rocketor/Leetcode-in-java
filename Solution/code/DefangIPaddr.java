import addition.ListNode;

/**
 * 维护一个StringBuffer对象，遍历参数字符串，
 * 将参数中的字符逐个追加到StringBuffer对象，
 * 每遇到字符'.'时，给StringBuffer中追加"[.]"
 */
public class DefangIPaddr {

    public String defangIPaddr(String address) {
        StringBuffer result = new StringBuffer("");
        for(int i = 0; i < address.length(); i++){

            String dig = address.charAt(i) == '.' ? "[.]" : address.charAt(i) + "";
            result.append(dig);
        }

        return result.toString();
    }
}
