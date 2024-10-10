package com.honeywell.dvm_media_player.video;

import android.content.Context;

import androidx.media3.common.util.Clock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.DefaultLoadControl;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.RenderersFactory;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.MediaSourceFactory;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.extractor.DefaultExtractorsFactory;

@UnstableApi
public class DvmPlayer {
    private static RenderersFactory renderersFactory;
    private static MediaSourceFactory mediaSourceFactory;
    private static DefaultExtractorsFactory extractorsFactory;
    private static DefaultTrackSelector trackSelector;
    private static DefaultLoadControl loadControl;
    private static BandwidthMeter bandwidthMeter;

    public static ExoPlayer initializeExoPlayer(Context context) {
        context = context.getApplicationContext();

        return new ExoPlayer.Builder(
                context,
                getRenderersFactory(context),
                getMediaSourceFactory(context),
                getTrackSelector(context),
                getLoadControl(),
                getBandwidthMeter(context),
                getAnalyticsCollector()
        ).build();
    }
    private static RenderersFactory getRenderersFactory(Context context) {
        if (renderersFactory == null) {
            renderersFactory = new DefaultRenderersFactory(context);
        }
        return renderersFactory;
    }
    private static MediaSourceFactory getMediaSourceFactory(Context context) {
        if (mediaSourceFactory == null) {
            mediaSourceFactory = new DefaultMediaSourceFactory(context, getExtractorsFactory());
        }
        return mediaSourceFactory;
    }
    private static DefaultExtractorsFactory getExtractorsFactory() {
        if (extractorsFactory == null) {
            extractorsFactory = new DefaultExtractorsFactory();
        }
        return extractorsFactory;
    }
    private static DefaultTrackSelector getTrackSelector(Context context) {
        if (trackSelector == null) {
            trackSelector = new DefaultTrackSelector(context);
        }
        return trackSelector;
    }
    private static DefaultLoadControl getLoadControl() {
        if (loadControl == null) {
            loadControl = new DefaultLoadControl.Builder().build();
        }
        return loadControl;
    }
    private static BandwidthMeter getBandwidthMeter(Context context) {
        if (bandwidthMeter == null) {
            bandwidthMeter = DefaultBandwidthMeter.getSingletonInstance(context);
        }
        return bandwidthMeter;
    }

    // not a singleton; reuse causes fatal exception
    private static DefaultAnalyticsCollector getAnalyticsCollector() {
        return new DefaultAnalyticsCollector(Clock.DEFAULT);
    }
}
