package com.example.pajoheshgram.ui.chats;

import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class ChatsViewModel extends ViewModel {

    public List<ChatItem> getMockChats() {
        List<ChatItem> list = new ArrayList<>();
        list.add(new ChatItem("Ali", "سلام، خوبی؟", "14:35"));
        list.add(new ChatItem("Sara", "ببین اینو چک کن", "13:10"));
        list.add(new ChatItem("Group Dev", "شروع جلسه با تأخیر", "Yesterday"));
        return list;
    }
}
