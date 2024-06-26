//package rtv.pl.rtvshop.service;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import rtv.pl.rtvshop.model.Category;
//import rtv.pl.rtvshop.model.Item;
//import rtv.pl.rtvshop.repository.ItemRepository;
//import rtv.pl.rtvshop.repository.UserRepository;
//import rtv.pl.rtvshop.security.User;
//
//import java.util.List;
//
//@Configuration
//@RequiredArgsConstructor
//public class DBInit implements CommandLineRunner {
//    private final ItemRepository repository;
//    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder encoder;
//
//    @Override
//    public void run(String... args) throws Exception {
//        List<Item> items = List.of(
//                new Item("Telewizor LG", 399, 4.5, "https://cdn-img.neonet.pl/eyJidWNrZXQiOiJodHRwczovL2Nkbi5uZW9uZXQucGwiLCJrZXkiOiJrYXJ0eS9wbGlraS96ZGplY2lhLzM0L3RlbGV3aXpvci1sZy03NXVwODEwMDNsYS0zNTg1MzFmMV8xNDA0MjAyMV9TNDU1OVc5Qy5qcGciLCJlZGl0cyI6eyJ3ZWJwIjp7InF1YWxpdHkiOjgwfSwicmVzaXplIjp7ImZpdCI6ImNvbnRhaW4iLCJiYWNrZ3JvdW5kIjp7InIiOjI1NSwiZyI6MjU1LCJiIjoyNTUsImFscGhhIjoxfSwiaGVpZ2h0IjoxNTAwfX19/telewizor-lg-75up81003la-358531f1_14042021_S4559W9C.jpg", "LG", true, Category.TV),
//                new Item("Telewizor Samsung", 499.99, 4.3, "https://cdn-img.neonet.pl/eyJidWNrZXQiOiJodHRwczovL2Nkbi5uZW9uZXQucGwiLCJrZXkiOiJrYXJ0eS9wbGlraS96ZGplY2lhLzAyL3RlbGV3aXpvci1zYW1zdW5nLXFlNDNxNjBjYXUtcWxlZC00ay10aXplbi1kdmItdDItaGV2Yy0zNzgyNzNmMV8yMDIzMDMzMF9ZTTZYWDlHTC5qcGciLCJlZGl0cyI6eyJ3ZWJwIjp7InF1YWxpdHkiOjgwfSwicmVzaXplIjp7ImZpdCI6ImNvbnRhaW4iLCJiYWNrZ3JvdW5kIjp7InIiOjI1NSwiZyI6MjU1LCJiIjoyNTUsImFscGhhIjoxfSwiaGVpZ2h0IjoxNTAwfX19/telewizor-samsung-qe43q60cau-qled-4k-tizen-dvb-t2-hevc-378273f1_20230330_YM6XX9GL.jpg", "Samsung", true, Category.TV),
//                new Item("Laptop HP", 1499.00, 3.9, "https://cdn-img.neonet.pl/eyJidWNrZXQiOiJodHRwczovL2Nkbi5uZW9uZXQucGwiLCJrZXkiOiJrYXJ0eS9wbGlraS96ZGplY2lhLzE1L2xhcHRvcC1ocC0yNTAtZzktaTUtMTIzNXUtOGdiLTUxMmdiLTE1LTYtZmhkLXcxMWgtM3ktZWR1LTM4Nzg1N2YxXzIwMjMxMTIyX0NDRlVYTTZOLmpwZyIsImVkaXRzIjp7IndlYnAiOnsicXVhbGl0eSI6ODB9LCJyZXNpemUiOnsiZml0IjoiY29udGFpbiIsImJhY2tncm91bmQiOnsiciI6MjU1LCJnIjoyNTUsImIiOjI1NSwiYWxwaGEiOjF9LCJoZWlnaHQiOjE1MDB9fX0=/laptop-hp-250-g9-i5-1235u-8gb-512gb-15-6-fhd-w11h-3y-edu-387857f1_20231122_CCFUXM6N.jpg", "HP", false, Category.COMPUTER),
//                new Item("Lodówka LG", 800, 5.0, "https://cdn-img.neonet.pl/eyJidWNrZXQiOiJodHRwczovL2Nkbi5uZW9uZXQucGwiLCJrZXkiOiJrYXJ0eS9wbGlraS96ZGplY2lhLzA1L2xvZG93a2EtbGctZ2JiNzJtY2Vnbi0zNjQwMDBmMV8yMjEwMjAyMV8wS0NDM0EyRi5qcGciLCJlZGl0cyI6eyJ3ZWJwIjp7InF1YWxpdHkiOjgwfSwicmVzaXplIjp7ImZpdCI6ImNvbnRhaW4iLCJiYWNrZ3JvdW5kIjp7InIiOjI1NSwiZyI6MjU1LCJiIjoyNTUsImFscGhhIjoxfSwiaGVpZ2h0IjoxNTAwfX19/lodowka-lg-gbb72mcegn-364000f1_22102021_0KCC3A2F.jpg", "LG", true, Category.BIG_AGD),
//                new Item("Toster VICCIO", 800, 2.3, "https://cdn-img.neonet.pl/eyJidWNrZXQiOiJodHRwczovL2Nkbi5uZW9uZXQucGwiLCJrZXkiOiJrYXJ0eS9wbGlraS96ZGplY2lhLzI1L3Rvc3Rlci12aWNjaW8tdGxkLTcwNTEtay16ZS1zdGVyb3dhbmllbS1kb3R5a293eW0tMzg4MTIyZjFfMjAyNDAxMDlfSUpTR04yVTcuanBnIiwiZWRpdHMiOnsid2VicCI6eyJxdWFsaXR5Ijo4MH0sInJlc2l6ZSI6eyJmaXQiOiJjb250YWluIiwiYmFja2dyb3VuZCI6eyJyIjoyNTUsImciOjI1NSwiYiI6MjU1LCJhbHBoYSI6MX0sImhlaWdodCI6MTUwMH19fQ==/toster-viccio-tld-7051-k-ze-sterowaniem-dotykowym-388122f1_20240109_IJSGN2U7.jpg", "VICCIO", false, Category.SMALL_AGD),
//                new Item("Iphone 14", 3800, 5.0, "https://cdn-img.neonet.pl/eyJidWNrZXQiOiJodHRwczovL2Nkbi5uZW9uZXQucGwiLCJrZXkiOiJrYXJ0eS9wbGlraS96ZGplY2lhLzQ1L3NtYXJ0Zm9uLWFwcGxlLWlwaG9uZS0xNC0xMjhnYi1jemFybnktbXB1ZjNweC1hLTM3NDc0OWYxXzIwMjIxMTI4X1QyMFVCSVdYLmpwZyIsImVkaXRzIjp7IndlYnAiOnsicXVhbGl0eSI6ODB9LCJyZXNpemUiOnsiZml0IjoiY29udGFpbiIsImJhY2tncm91bmQiOnsiciI6MjU1LCJnIjoyNTUsImIiOjI1NSwiYWxwaGEiOjF9LCJoZWlnaHQiOjE1MDB9fX0=/smartfon-apple-iphone-14-128gb-czarny-mpuf3px-a-374749f1_20221128_T20UBIWX.jpg", "Apple", true, Category.PHONE),
//                new Item("Piekarnik Gorenje", 1800, 2.9, "https://cdn-img.neonet.pl/eyJidWNrZXQiOiJodHRwczovL2Nkbi5uZW9uZXQucGwiLCJrZXkiOiJrYXJ0eS9wbGlraS96ZGplY2lhLzdBL3BpZWthcm5pay1nb3JlbmplLWJwczY3NDdhMDZiZy0zNzAyMjVmMV8yMDIyMDQwNV9FMkZVRkRCRC5qcGciLCJlZGl0cyI6eyJ3ZWJwIjp7InF1YWxpdHkiOjgwfSwicmVzaXplIjp7ImZpdCI6ImNvbnRhaW4iLCJiYWNrZ3JvdW5kIjp7InIiOjI1NSwiZyI6MjU1LCJiIjoyNTUsImFscGhhIjoxfSwiaGVpZ2h0IjoxNTAwfX19/piekarnik-gorenje-bps6747a06bg-370225f1_20220405_E2FUFDBD.jpg", "Gorenje", true, Category.BIG_AGD),
//                new Item("Pralka BEKO", 1800, 3.9, "https://cdn-img.neonet.pl/eyJidWNrZXQiOiJodHRwczovL2Nkbi5uZW9uZXQucGwiLCJrZXkiOiJrYXJ0eS9wbGlraS96ZGplY2lhLzY4L3ByYWxrYS1iZWtvLXdpdHY4NzEyeDB3LTM1OTg3OGYxXzI0MDMyMDIxX01ZUTNFRTBELnBuZyIsImVkaXRzIjp7IndlYnAiOnsicXVhbGl0eSI6ODB9LCJyZXNpemUiOnsiZml0IjoiY29udGFpbiIsImJhY2tncm91bmQiOnsiciI6MjU1LCJnIjoyNTUsImIiOjI1NSwiYWxwaGEiOjF9LCJoZWlnaHQiOjE1MDB9fX0=/pralka-beko-witv8712x0w-359878f1_24032021_MYQ3EE0D.png", "BEKO", false, Category.BIG_AGD),
//                new Item("Zmywarka Electrolux", 3499.99, 4.9, "https://cdn-img.neonet.pl/eyJidWNrZXQiOiJodHRwczovL2Nkbi5uZW9uZXQucGwiLCJrZXkiOiJrYXJ0eS9wbGlraS96ZGplY2lhLzMzL3pteXdhcmthLWVsZWN0cm9sdXgtZWVjNzY3MzEwbC0zNjE4ODBmMV8xMDA2MjAyMV9LQjFERk5YQi5qcGciLCJlZGl0cyI6eyJ3ZWJwIjp7InF1YWxpdHkiOjgwfSwicmVzaXplIjp7ImZpdCI6ImNvbnRhaW4iLCJiYWNrZ3JvdW5kIjp7InIiOjI1NSwiZyI6MjU1LCJiIjoyNTUsImFscGhhIjoxfSwiaGVpZ2h0IjoxNTAwfX19/zmywarka-electrolux-eec767310l-361880f1_10062021_KB1DFNXB.jpg", "Electrolux", false, Category.BIG_AGD),
//                new Item("Pralka Gorenje", 2499.99, 4.9, "https://cdn-img.neonet.pl/eyJidWNrZXQiOiJodHRwczovL2Nkbi5uZW9uZXQucGwiLCJrZXkiOiJrYXJ0eS9wbGlraS96ZGplY2lhLzI2L3ByYWxrYS1nb3JlbmplLXdwbmE4NGF0c3dpZmkzLXBsLTM4NTUyM2YxXzIwMjMxMTE1X05XNE02OUxOLmpwZyIsImVkaXRzIjp7IndlYnAiOnsicXVhbGl0eSI6ODB9LCJyZXNpemUiOnsiZml0IjoiY29udGFpbiIsImJhY2tncm91bmQiOnsiciI6MjU1LCJnIjoyNTUsImIiOjI1NSwiYWxwaGEiOjF9LCJoZWlnaHQiOjE1MDB9fX0=/pralka-gorenje-wpna84atswifi3-pl-385523f1_20231115_NW4M69LN.jpg", "Gorenje", true, Category.BIG_AGD),
//                new Item("Mikrofalówka Panasonic", 499.99, 3.4, "https://cdn-img.neonet.pl/eyJidWNrZXQiOiJodHRwczovL2Nkbi5uZW9uZXQucGwiLCJrZXkiOiJrYXJ0eS9wbGlraS96ZGplY2lhLzJDL21pa3JvZmFsb3drYS1wYW5hc29uaWMtbm4tZTIyam1tZXBnLTM4NTQzNWYxXzIwMjMwOTI4X0JKQkIxME01LmpwZyIsImVkaXRzIjp7IndlYnAiOnsicXVhbGl0eSI6ODB9LCJyZXNpemUiOnsiZml0IjoiY29udGFpbiIsImJhY2tncm91bmQiOnsiciI6MjU1LCJnIjoyNTUsImIiOjI1NSwiYWxwaGEiOjF9LCJoZWlnaHQiOjE1MDB9fX0=/mikrofalowka-panasonic-nn-e22jmmepg-385435f1_20230928_BJBB10M5.jpg", "Panasonic", true, Category.SMALL_AGD),
//                new Item("Blender Russell", 250.00, 3.2, "https://cdn-img.neonet.pl/eyJidWNrZXQiOiJodHRwczovL2Nkbi5uZW9uZXQucGwiLCJrZXkiOiJrYXJ0eS9wbGlraS96ZGplY2lhLzI3L3J1c3NlbGwtaG9iYnMtcmV0cm8taGFuZC1ibGVuZGVyLWNyZWFtLTI1MjMyLTU2LTMzNTEyNmYxLnBuZyIsImVkaXRzIjp7IndlYnAiOnsicXVhbGl0eSI6ODB9LCJyZXNpemUiOnsiZml0IjoiY29udGFpbiIsImJhY2tncm91bmQiOnsiciI6MjU1LCJnIjoyNTUsImIiOjI1NSwiYWxwaGEiOjF9LCJoZWlnaHQiOjE1MDB9fX0=/russell-hobbs-retro-hand-blender-cream-25232-56-335126f1.png", "Russell", true, Category.SMALL_AGD)
//        );
//        repository.saveAll(items);
//
//        User user = new User("a", encoder.encode("a"), "a", "a", "a", "a", "a", "a", "a", "a");
//        userRepository.save(user);
//    }
//}
