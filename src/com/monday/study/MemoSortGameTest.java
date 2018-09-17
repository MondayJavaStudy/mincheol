package com.monday.study;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by mcpark on 9/17/18
 */
public class MemoSortGameTest {
    private static final MemoSortGame game = new MemoSortGame();

    @Test
    public void 정상적으로_정렬이_됩니다() {
        //Given
        List<String> memos = Arrays.asList(
                "2018/7/3 배민은행의 구조도를 손에 넣었다. 필요한 장비는 이런거 저런거 해서 각자 준비해야한다.",
                "타깃 은행은 잠실에 있는 배민은행으로 한다. 18년06월13일",
                "배민은행앞 별다방에서 18-06-12에 만나기로 함");

        //When
        List<String> sortedMemo = game.sortMemo(memos);

        //Then
        assertNotNull(sortedMemo);
        assertThat("", sortedMemo.size(), is(3));
        assertThat("", sortedMemo.get(0), containsString("18-06-12"));
        assertThat("", sortedMemo.get(1), containsString("18년06월13일"));
        assertThat("", sortedMemo.get(2), containsString("2018/7/3"));
    }
}
