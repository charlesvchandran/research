public class TestEnumComparison {

    public static void main(String[] args) {
        System.out.println("TABASC".equals(EnumComparison.IngestTarget.TABASCO.name()));

        String str = "scrt:058252555235";
        String joinStr = "succ-".concat(str);
                //String.join("succ-", str);
        System.out.println(joinStr);




    }


}
