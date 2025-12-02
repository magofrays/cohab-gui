package org.magofrays.cohab_gui.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.magofrays.cohab_gui.model.dto.task.CreateTaskDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService {
    private final WebClient webClient;
    private final HttpErrorHandler httpErrorHandler;

//    public void createTask(CreateTaskDto createTaskDto){
//        webClient.post().uri()
//    }
}
