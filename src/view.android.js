import React, {Component} from 'react';
import {requireNativeComponent, Dimensions, DeviceEventEmitter} from 'react-native';
const RNNativeListviewView = requireNativeComponent('NativeListviewView', null);

class NativeListview extends Component {

    constructor(props) {
        super(props);
    }

    componentWillMount() {
        DeviceEventEmitter.addListener('itemClicked', (e) => {
            if (this.props.onItemClicked) {
                this.props.onItemClicked(e);
            }
        });
    }

    render() {
        return (
            <RNNativeListviewView {...this.props}>
            </RNNativeListviewView>
        );
    }
}

NativeListview.propTypes = {
    onItemClicked: React.PropTypes.func,
    setBulletin: React.PropTypes.string.isRequired,
    setSelectedOddList: React.PropTypes.string.isRequired
};

export default NativeListview;
