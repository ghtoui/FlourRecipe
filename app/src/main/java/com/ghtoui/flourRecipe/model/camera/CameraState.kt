package com.ghtoui.flourRecipe.model.camera

/**
 * カメラの状態
 */
internal sealed interface CameraState {
    /**
     * 開く
     */
    data object Open : CameraState

    /**
     * 閉じる
     */
    data object Close : CameraState
}
