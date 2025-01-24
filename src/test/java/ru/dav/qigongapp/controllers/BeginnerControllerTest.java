//package ru.dav.qigongapp.controllers;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import javafx.scene.control.Pagination;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.StackPane;
//import ru.dav.qigongapp.models.Navigation;
//import ru.dav.qigongapp.models.PageContentImpl;
//import ru.dav.qigongapp.models.PageContentProvider;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//
//public class BeginnerControllerTest {
//
//    // region Переменные
//    @Mock
//    private AnchorPane beginnerPane;
//
//    @Mock
//    private Pagination paginationList;
//
//    @Mock
//    private StackPane stackPane;
//
//    @Mock
//    private ImageView backHome, img01, img02, img03, img04, img05, img06, img07, img08, img09, img10;
//
//    @Mock
//    private Navigation navigation;
//
//    @Mock
//    private PageContentProvider pageContentProvider;
//
//    @InjectMocks
//    private BeginnerController controller;
//
//    // endregion
//
//    // region method setUp
//    @BeforeEach
//    void setUp() {
//        // Подготовка необходимых объектов мока
//        controller = new BeginnerController();
//        controller.beginnerPane = beginnerPane;
//        controller.paginationList = paginationList;
//        controller.stackPane = stackPane;
//        controller.backHome = backHome;
//        controller.img01 = img01;
//        controller.img02 = img02;
//        controller.img03 = img03;
//        controller.img04 = img04;
//        controller.img05 = img05;
//        controller.img06 = img06;
//        controller.img07 = img07;
//        controller.img08 = img08;
//        controller.img09 = img09;
//        controller.img10 = img10;
//    }
//    // endregion
//
//    @Test
//    void testInitialize() {
//        // Выполнение метода initialize()
//        controller.initialize();
//
//        // Проверка вызовов методов
//        verify(navigation).switchToHomePage(beginnerPane, "/ru/dav/qigongapp/qigong-view.fxml");
//        verify((PageContentImpl) pageContentProvider, times(1))
//                .addImages(img01, img02, img03, img04, img05, img06, img07, img08, img09, img10);
//        verify(paginationList).setPageFactory(pageContentProvider::getPage);
//    }
//}
