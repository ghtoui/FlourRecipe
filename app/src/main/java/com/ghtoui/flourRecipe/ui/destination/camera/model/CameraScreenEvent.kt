package com.ghtoui.flourRecipe.ui.destination.camera.model

/**
 * カメラ画面のイベント
 */
internal sealed interface CameraScreenEvent {
    /**
     * 撮影した
     */
    data object TakePicture : CameraScreenEvent
}
