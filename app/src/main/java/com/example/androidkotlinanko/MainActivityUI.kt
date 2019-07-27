package com.example.androidkotlinanko

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.view.Gravity
import org.jetbrains.anko.*
import org.jetbrains.anko.design.longSnackbar

class MainActivityUI : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        /*ui.frameLayout {

        }*/
        // or below code
        frameLayout {
            val textField = editText {
                // this.hint = "Text for toasts and snackbars"
                // *** or because editText widget get "this" as receiver we can use without "this"
                hint = "Text for toasts and snackbars"

                // if we don't set any param for with and height the default is wrap-content
            }.lparams(width = matchParent) {
                margin = dip(12)
                topMargin = dip(30)
            }

            imageView(R.drawable.ic_android_black_24dp) {
                setOnClickListener {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        this@imageView.imageTintList = ColorStateList.valueOf(Color.parseColor("#4CAF50"))
                    }
                }
            }.lparams(dip(72), dip(72)) {
                gravity = Gravity.CENTER
            }

            linearLayout {

                button("Show toast") {
                    setOnClickListener {
                        if (textField.text.isEmpty()) {

                        } else {
                            toast(textField.text)

                        }
                    }
                }
                button("Show snackbar") {
                    setOnClickListener {
                        longSnackbar(this@frameLayout, textField.text.toString())
                    }
                }
            }.lparams {
                gravity = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
                bottomMargin = dip(72)
            }

        }
    }
}